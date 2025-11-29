package poo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@ConditionalOnProperty(name = "image.storage.type", havingValue = "cloud")
public class ImagemServiceNuvem implements ImagemService {

    @Value("${cloud.api.key:}")
    private String apiKey;

    @Override
    public String upload(MultipartFile file) throws IOException {
        // --- AREA DE IMPLEMENTACAO ---
        // TODO: Adicione aqui a logica do seu provedor de nuvem.
        // 1. Autenticar usando 'apiKey'
        // 2. Enviar o arquivo
        // 3. Retornar a URL gerada

        throw new UnsupportedOperationException("Integração de nuvem não implementada. Adicione sua lógica aqui.");
    }
}
