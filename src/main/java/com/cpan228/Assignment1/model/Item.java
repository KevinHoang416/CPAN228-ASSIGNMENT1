package com.cpan228.Assignment1.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    @NotBlank
    private String name;
    @NotBlank
    private int id;
    @Min(1000)
    private int price;
    @Min(2021)
    private int year_of_Creation;
    private Brand brandFrom;

    public enum Brand {
        Dior("Dior"), American_Eagle("American Eagle"), Polo("Polo"), Louis_Vuitton("Louis Vuitton");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
