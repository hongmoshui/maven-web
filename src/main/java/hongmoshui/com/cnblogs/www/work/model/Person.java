package hongmoshui.com.cnblogs.www.work.model;

public class Person
{
    /**
     * 年龄
     */
    private int age;

    /**
     * 名字
     */
    private String name;

    /**
     * 身高
     */
    private int height;

    /**
     * 体重(KG)
     */
    private int weight;

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Persion [age=" + age + ", name=" + name + ", height=" + height + ", weight=" + weight + "]";
    }

}
