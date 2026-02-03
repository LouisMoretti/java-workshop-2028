package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name","nickname"})
@ToString
public class Horse {
    @Setter public String name;
    @ToString.Exclude @Setter public String nickname;
    public int speed;
}
