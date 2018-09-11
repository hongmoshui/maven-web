package hongmoshui.com.cnblogs.www.work.model;

/**
 * 用户信息
 * @author hWX492476
 */
public class UserInfo
{
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户手机号
     */
    private String phoneNumber;

    /**
     * 其它信息
     */
    private String others;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getOthers()
    {
        return others;
    }

    public void setOthers(String others)
    {
        this.others = others;
    }
}
