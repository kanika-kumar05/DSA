# Write your MySQL query statement below
with ranked as(select *,lag(temperature)over(order by recordDate)as prev_temp,
lag(recordDate) over (order by recordDate) as prev_date from Weather)

select id from ranked where temperature>prev_temp and DATEDIFF(recordDate,prev_date)=1