package com.mtec.generateqr;


import net.glxn.qrgen.QRCode;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRCodeService {
    public byte[] generateQRCode(String text, int width, int height) throws IOException {
        ByteArrayOutputStream stream = QRCode
                .from(text)
                .withSize(width, height)
                .stream();
        return stream.toByteArray();
    }
}
