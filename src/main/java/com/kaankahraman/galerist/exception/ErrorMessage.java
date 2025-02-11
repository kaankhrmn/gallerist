package com.kaankahraman.galerist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String ofStatic; //kişininin static setlemek istediği değer varsa bunu kullanır
    private MessageType type;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(type.getMessage());
        if(this.ofStatic != null) {
            builder.append(" : "+ ofStatic);
        }
        return builder.toString();
    }
}
