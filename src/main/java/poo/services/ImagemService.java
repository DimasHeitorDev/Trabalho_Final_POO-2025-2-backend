package poo.services;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ImagemService {
    String upload(MultipartFile file) throws IOException;
}
