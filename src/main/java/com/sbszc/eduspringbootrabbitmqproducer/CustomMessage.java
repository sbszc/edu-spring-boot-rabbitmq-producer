package com.sbszc.eduspringbootrabbitmqproducer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CustomMessage {
    private String messageId;
    private String message;
    private Date messageDate;
}
