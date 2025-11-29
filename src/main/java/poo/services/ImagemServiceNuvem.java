package poo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.util.Map;

@Service
@ConditionalOnProperty(name = "image.storage.type", havingValue = "cloud")
public class ImagemServiceNuvem implements ImagemService {

    @Value("${cloud.name:}")
    private String cloudName;

    @Value("${cloud.api.key:}")
    private String apiKey;

    @Value("${cloud.api.secret:}")
    private String apiSecret;

    private Cloudinary cloudinary;

    @PostConstruct
    public void init() {
        // Inicializa o cliente do Cloudinary com as credenciais fornecidas via
        // variáveis de ambiente
        if (cloudName != null && !cloudName.isEmpty()) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret));
        }
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        // --- AREA DE IMPLEMENTACAO ---
        // Exemplo de implementação usando Cloudinary.
        // O desenvolvedor pode substituir este bloco pelo serviço de sua preferência
        // (AWS S3, Google Cloud, Azure, etc).

        if (cloudinary == null) {
            throw new IllegalStateException(
                    "Cloudinary não configurado. Verifique as variáveis de ambiente CLOUD_NAME, CLOUD_API_KEY e CLOUD_API_SECRET.");
        }

        try {
            // Upload para o Cloudinary
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

            // Retorna a URL segura (https) da imagem enviada
            return (String) uploadResult.get("secure_url");
        } catch (Exception e) {
            throw new IOException("Falha ao fazer upload da imagem para a nuvem", e);
        }
    }
}
