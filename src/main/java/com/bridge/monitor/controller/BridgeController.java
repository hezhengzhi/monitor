package com.bridge.monitor.controller;

import com.bridge.monitor.entity.BridgePo;
import com.bridge.monitor.entity.RegionPo;
import com.bridge.monitor.model.BridgeInVo;
import com.bridge.monitor.service.BridgeService;
import com.bridge.monitor.util.HttpResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "桥梁信息")
@RestController
@RequestMapping(value = "/bridge")
@Slf4j
public class BridgeController {
    @Resource
    private BridgeService bridgeService;


    @GetMapping(value = "/findRegion")
    @ApiOperation(value = "根据区域等级和上级code查询区域信息", notes = "根据区域等级和上级code查询区域信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "区域等级：1省 2市 3区",name = "level",required = true,paramType = "query"),
            @ApiImplicitParam(value = "上级code",name = "pid",paramType = "query")
    })
    public HttpResponse<List<RegionPo>> findRegion(int level , Integer pid ){
        return bridgeService.findRegion(level,pid);
    }


    @GetMapping(value = "/findAll")
    @ApiOperation(value = "查询桥梁信息", notes = "查询桥梁信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "区号",name = "areaId",paramType = "query"),
            @ApiImplicitParam(value = "桥梁名称",name = "bridgeName",paramType = "query"),
            @ApiImplicitParam(value = "分页大小",name = "pageSize", required = true,paramType = "query"),
            @ApiImplicitParam(value = "页码",name = "pageNum",paramType = "query",required = true)
    })
    public HttpResponse<Page<BridgePo>> findBridge(Integer areaId,String bridgeName,int pageSize,int pageNum){
        return bridgeService.findBridge(areaId,bridgeName,pageSize,pageNum);
    }


    @PostMapping(value = "/save")
    @ApiOperation(value = "保存桥梁信息", notes = "保存桥梁信息")
    public HttpResponse<String> save(@RequestBody BridgeInVo bridgeInVo){
        return bridgeService.save(bridgeInVo);
    }

    @GetMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除桥梁数据", notes = "删除桥梁数据")
    public HttpResponse<String> delete(@PathVariable(value = "id")@ApiParam(value = "删除的id",name = "id",required = true) int id){
        return bridgeService.delete(id);
    }
}
