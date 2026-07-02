package Enums;
public enum SatisfactionOfTheService {
    /**Fields of the Enum from One - Five, {@linkplain String} converts to {@linkplain Integer}
     */
    One (1) ,
    Two(2),
    Three (3),
    Four (4),
    Five(5);
    /**Private final int field "number" just to convert the Enum from {@linkplain String} type to {@linkplain Integer}
     */
    private final int number;
    /**
     *Constructor of the Enum {@linkplain SatisfactionOfTheService}
     * @param number
     */
    SatisfactionOfTheService(int number) {
        this.number = number;
    }
    /**
     * public method "getValue" in order to get numeric representation of the Enum {@linkplain SatisfactionOfTheService}
     * @param : None
     * @return field "number"
     */
    public int getValue() {
        return number;
    }
}

