SELECT INGREDIENT_TYPE,	sum(total_order) as TOTAL_ORDER
FROM ICECREAM_INFO info, FIRST_HALF fh
where info.flavor = fh.flavor
group by ingredient_type
order by TOTAL_ORDER;

-- INNER JOIN 풀이
SELECT INGREDIENT_TYPE, sum(total_orders) as TOTAL_ORDERS
FROM FIRST_HALF fh
    INNER JOIN ICECREAM_INFO info
    ON info.flavor = fh.flavor
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDERS;