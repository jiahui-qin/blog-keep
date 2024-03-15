package fate.saber.blogkeep.entity;

public enum GenderEnum {
    male("male", "男"),
    female("female", "女");

    private String code;

    private String desc;

    GenderEnum(String c, String s) {
        this.code = c;
        this.desc = s;
    }
}
