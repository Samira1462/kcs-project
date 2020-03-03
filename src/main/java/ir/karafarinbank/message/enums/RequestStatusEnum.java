package ir.karafarinbank.message.enums;

public enum RequestStatusEnum
{
    NOT_REGISTERED(1L),
    REGISTERED(2L),
    REJECT(3L),
    UNKNOWN(4L),
    ACCEPTED(5L);

    private final Long id;

    RequestStatusEnum(Long id)
    {
        this.id = id;
    }

    public Long getValue()
    {
        return id;
    }
}
