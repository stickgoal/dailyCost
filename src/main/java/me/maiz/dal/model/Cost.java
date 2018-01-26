package me.maiz.dal.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Lucas on 2017-03-13.
 */
@Entity
@Table(name="dc_cost")
public class Cost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_id")
    private long costId;

    /**
     * 收支类型：PAY支出   RECV 收入
     */
    private String type;

    /**
     * 类别，如：餐饮费
     */
    @Column(length = 128)
    private String category;

    /**
     * 用户ID
     */
    private long userId;

    /**
     * 开销金额
     */
    @Column(length = 17,precision = 2)
    private double amount;

    /**
     * 开销发生时间
     */
    private LocalDateTime costTime;

    /**
     * 记账时间
     */
    private LocalDateTime tallyTime;

    /**
     * 备注
     */
    @Column(length = 1024)
    private String memo;


    public long getCostId() {
        return costId;
    }

    public void setCostId(long costId) {
        this.costId = costId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCostTime() {
        return costTime;
    }

    public void setCostTime(LocalDateTime costTime) {
        this.costTime = costTime;
    }

    public LocalDateTime getTallyTime() {
        return tallyTime;
    }

    public void setTallyTime(LocalDateTime tallyTime) {
        this.tallyTime = tallyTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("costId", costId)
                .add("type", type)
                .add("category", category)
                .add("userId", userId)
                .add("amount", amount)
                .add("costTime", costTime)
                .add("tallyTime", tallyTime)
                .add("memo", memo)
                .toString();
    }
}
