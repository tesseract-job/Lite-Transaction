CREATE TABLE `lite_transaction_undo_log`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT comment '自增id',
    `branch_id`     bigint(20)   NOT NULL comment '事务分支id',
    `xid`           varchar(100) NOT NULL comment '事务全局id',
    `context`       varchar(128) NOT NULL comment '事务上下文',
    `rollback_info` longblob     NOT NULL comment '回滚信息',
    `log_status`    int(11)      NOT NULL comment '状态',
    `log_created`   datetime     NOT NULL comment '创建时间',
    `log_modified`  datetime     NOT NULL comment '最后修改时间',
    `ext`           varchar(100) DEFAULT NULL comment '扩展字段',
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;