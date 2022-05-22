package models;

public class Invoice {
    private String title;
    private String name;
    private Integer pelak;
    private Integer weight;
    private Long price;
    private String date;
    private String time;
    private Long totalPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPelak() {
        return pelak;
    }

    public void setPelak(Integer pelak) {
        this.pelak = pelak;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String serialize() {
        String result =
                title
                + "--" +
                name
                + "--" +
                pelak
                + "--" +
                weight
                + "--" +
                price
                + "--" +
                totalPrice
                + "--" +
                date
                + "--" +
                time;

        return result;
    }

    public Invoice deserialize(String str) {
        String[] split = str.split("--");
        this.setTitle(split[0]);
        this.setName(split[1]);
        this.setPelak(Integer.valueOf(split[2]));
        this.setWeight(Integer.valueOf(split[3]));
        this.setPrice(Long.valueOf(split[4]));
        this.setTotalPrice(Long.valueOf(split[5]));
        this.setDate(split[6]);
        this.setTime(split[7]);
        return this;
    }
}
