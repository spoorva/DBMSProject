package model;

public class ustransportation {
    public String series_id ;
    public String year;
    public String period;
    public String value ;

    public ustransportation(String series_id, String year, String period, String value) {
        super();
        this.series_id = series_id;
        this.year = year;
        this.period = period;
        this.value = value;
    }
    public ustransportation(String id, String val) {
        series_id = id;
        value = val;
    }
    public ustransportation(String id) {
        series_id = id;
    }
    public String getseries_id() {
        return series_id;
    }

    public void setseries_id(String series_id) {
        this.series_id = series_id;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }


}
