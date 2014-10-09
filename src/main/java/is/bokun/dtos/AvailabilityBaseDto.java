package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "availabilityBase")
@XmlType(name = "AvailabilityBase")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityBaseDto {

    public Long id;
    public boolean dateRangeConditionActive;
    public DateTime startDate;
    public DateTime endDate;
    public boolean recurringDateRange;
    public int recurringStartDay, recurringEndDay;
    public int recurringStartMonth, recurringEndMonth;

    public boolean cronConditionActive;
    public String cron;
    public boolean flagConditionActive;
    public List<String> flags = new ArrayList<>();
    public String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDateRangeConditionActive() {
        return dateRangeConditionActive;
    }

    public void setDateRangeConditionActive(boolean dateRangeConditionActive) {
        this.dateRangeConditionActive = dateRangeConditionActive;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isCronConditionActive() {
        return cronConditionActive;
    }

    public void setCronConditionActive(boolean cronConditionActive) {
        this.cronConditionActive = cronConditionActive;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public boolean isFlagConditionActive() {
        return flagConditionActive;
    }

    public void setFlagConditionActive(boolean flagConditionActive) {
        this.flagConditionActive = flagConditionActive;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRecurringStartDay() {
        return recurringStartDay;
    }

    public void setRecurringStartDay(int recurringStartDay) {
        this.recurringStartDay = recurringStartDay;
    }

    public int getRecurringEndDay() {
        return recurringEndDay;
    }

    public void setRecurringEndDay(int recurringEndDay) {
        this.recurringEndDay = recurringEndDay;
    }

    public int getRecurringStartMonth() {
        return recurringStartMonth;
    }

    public void setRecurringStartMonth(int recurringStartMonth) {
        this.recurringStartMonth = recurringStartMonth;
    }

    public int getRecurringEndMonth() {
        return recurringEndMonth;
    }

    public void setRecurringEndMonth(int recurringEndMonth) {
        this.recurringEndMonth = recurringEndMonth;
    }
}
