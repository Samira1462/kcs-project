package ir.karafarinbank.message;

import ir.karafarinbank.message.enums.ResponseStatusEnum;

public class Response {

    private ResponseStatusEnum status;
    private String description;
    private Object data;

    public Response(){ }

    public Response(ResponseStatusEnum status, String description, Object data)
    {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ResponseStatusEnum getStatus()
    {
        return status;
    }

    public void setStatus(ResponseStatusEnum status)
    {
        this.status = status;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
