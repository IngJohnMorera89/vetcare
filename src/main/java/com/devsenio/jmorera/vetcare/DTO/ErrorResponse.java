package com.devsenio.jmorera.vetcare.DTO;

import java.time.LocalDateTime;

public record ErrorResponse(
        int codigo,
        String mensaje,
        LocalDateTime fecha

) {

}
