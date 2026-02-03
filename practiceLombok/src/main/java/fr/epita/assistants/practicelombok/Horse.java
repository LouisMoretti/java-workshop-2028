package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name","nickname"})
@ToString
public class Horse {
    @Setter private String name;
    @ToString.Exclude @Setter private String nickname;
    private int speed;
}
