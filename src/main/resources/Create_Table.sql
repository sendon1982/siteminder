--# tushare DB

CREATE TABLE `dragon_tiger_stock`
(
	id					bigint primary key AUTO_INCREMENT,
    code   				varchar(20),
    name   				varchar(100),
    pchange    			decimal(10,4),
    amount       		decimal(15,2),
    buy      			decimal(15,2),
    sell                decimal(15,2),
    reason 				varchar(500),
    bratio 				decimal(6,2),
    sratio        		decimal(6,2),
    ts_date				date,
    broker				varchar(200),
    count 				int,
	probability       	decimal(6,2),
	broker_buy   		decimal(15,2),
	broker_buy_prop    	decimal(6,2),
	broker_sell 		decimal(15,2),
	broker_sell_prop    decimal(6,2),
	net					decimal(15,2)
);

ALTER TABLE `dragon_tiger_stock` ADD UNIQUE `unique_index`(`code`, `ts_date`, `broker`, `reason`);

CREATE TABLE `broker_buy_summary`
(
    id					bigint primary key AUTO_INCREMENT,
    broker_code   		varchar(20),
    broker_name      	varchar(100),
    s_money    			decimal(10,4),
    b_money       		decimal(15,2),
    jm_money      		decimal(15,2),
    b_count 		    int,
    s_Count         	int,
    ts_date				date
);

CREATE TABLE `broker_buy_stock_info`
(
    id					    bigint primary key AUTO_INCREMENT,
    broker_buy_summary_id   bigint,
    stock_code  		    varchar(20),
    stock_name				varchar(100)
);


