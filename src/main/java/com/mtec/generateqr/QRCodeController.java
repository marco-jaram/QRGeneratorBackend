package com.mtec.generateqr;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate-qr")
    public void generateQRCode(@RequestParam("url") String url, HttpServletResponse response) throws IOException {
        byte[] qrCode = qrCodeService.generateQRCode(url, 250, 250);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.getOutputStream().write(qrCode);
    }
}
