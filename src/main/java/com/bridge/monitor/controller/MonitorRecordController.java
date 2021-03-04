package com.bridge.monitor.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "查询同步数据记录")
@RestController
@RequestMapping(value = "/record")
@Slf4j
public class MonitorRecordController {
}
