package org.example.info;

public enum Status {
    DONE(1) ,
    IN_PROGRESS(2),
    NOT_DONE(3);

    private Integer point;

   Status(Integer point) {
       this.point = point;
    }

    public Integer getPoint() {
        return point;
    }
}
