package me.maiz.web.form;


import com.google.common.base.MoreObjects;
import me.maiz.common.web.BaseForm;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Lucas on 2017-03-13.
 */
public class TallyForm extends BaseForm {
    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String category;

    private String memo;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                .add("amount", amount)
                .add("category", category)
                .add("memo", memo)
                .toString();
    }
}
