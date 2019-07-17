/**
 * 仓库
 * @param value
 * @returns
 */
var storage = new getDefaultStorage();

function getWarehouseName(value) {
    return storage.get("warehouseName");
}

//库位是否启用状态
function warehouseLocationStatus(value) {
    if (value == 0) {
        return "存盘";
    } else if (value == 1) {
        return "停用";
    } else if (value == 2) {
        return "启用";
    } else {
        return value;
    }
}

//库位使用状态
function warehouseLocationUseStatus(value) {
    if (value == 0) {
        return "空闲";
    } else if (value == 1) {
        return "使用";
    } else if (value == 2) {
        return "空";
    } else {
        return value;
    }
}

//商品属性
function goodsQualityType(value) {
    if (value == 0) {
        return "残品";
    } else if (value == 1) {
        return "正品";
    } else {
        return value;
    }
}

//采购单状态
function inboundOrderStatus(value) {
    if (value == 0) {
        return "已取消";
    } else if (value == 100) {
        return "到货登记";
    } else if (value == 150) {
        return "品控质检";
    } else if (value == 200) {
        return "收货中";
    } else if (value == 300) {
        return "已完成";
    } else if (value == 350) {
        return "已关闭";
    } else {
        return value;
    }
}

function receivingStatus(value) {
    if (value == 0) {
        return "作废";
    } else if (value == 100) {
        return "存盘";
    } else if (value == 300) {
        return "确认";
    } else if (value == 500) {
        return "审核入库";
    } else {
        return value;
    }
}

/**
 * 上架状态
 *
 * @param value
 * @returns
 */
function putAwayStatus(value) {
    if (value == 100) {
        return "未开始";
    } else if (value == 300) {
        return "上架中";
    } else if (value == 500) {
        return "已上架";
    } else {
        return value;
    }
}

/**
 * 业务类型
 *
 * @param value
 * @returns
 */
function sourceBusinessType(value) {
    if (value == 1) {
        return "采购入库";
    } else if (value == 2) {
        return "移动";
    } else if (value == 3) {
        return "取消订单";
    } else {
        return value;
    }
}

/**
 * 损益类型
 * @param value
 * @returns {*}
 */
function profitLossType(value) {
    if (value == 1) {
        return "报益";
    } else if (value == 2) {
        return "报损";
    } else {
        return value;
    }
}

/**
 * 损益单状态
 * @param value
 * @returns {*}
 */
function profitLossStatus(value) {
    if (value == 0) {
        return "作废";
    } else if (value == 100) {
        return "存盘";
    } else if (value == 200) {
        return "确认";
    } else if (value == 300) {
        return "审核通过";
    } else if (value == 400) {
        return "审核驳回";
    } else {
        return value;
    }
}

/**
 * 报废原因
 * @param value
 * @returns {*}
 */
function scrapReason(value) {
    if (value == 0) {
        return "进冻结期报废";
    } else if (value == 1) {
        return "库内巡检报废";
    } else if (value == 2) {
        return "加工损耗报废";
    } else if (value == 3) {
        return "库内作业报废";
    } else if (value == 4) {
        return "消退商品问题入库报废";
    } else if (value == 5) {
        return "消退物流问题入库报废";
    } else {
        return value;
    }
}

/**
 * 处理方式
 * @param value
 * @returns {*}
 */
function handleMode(value) {
    if (value == 0) {
        return "抛弃";
    } else if (value == 1) {
        return "公司内售";
    } else if (value == 2) {
        return "库房内售";
    } else {
        return value;
    }
}

/**
 * 商品扩展属性启用状态
 */
function showGoodsAttributeStatus(value) {
    if (value == 1)
        return '启用';
    else if (value == 0)
        return '未启用';
}

/**
 * 盘点类型
 */
function reviewType(value) {
    if (value == "BLINDNESS") {
        return "盲盘";
    } else if (value == "HALF_BLINDNESS") {
        return "半盲盘";
    } else {
        return value;
    }
}

/**
 * 盘点状态
 */
function reviewStatus(value) {
    if (value == "NEW") {
        return "新增";
    } else if (value == "CLAIM") {
        return "已领用";
    } else if (value == "IN_PROGRESS") {
        return "进行中";
    } else if (value == "COMPLETION") {
        return "已完成";
    } else {
        return value;
    }
}

function isSecond(value) {
    if (value == 2) {
        return "是";
    } else {
        return "否";
    }
}

function isThird(value) {
    if (value == 3) {
        return "是";
    } else {
        return "否";
    }
}

/**
 * 其他出库-出库类型
 */
function isOtherShipmentType(value) {
    if (value == 1) {
        return "采购退货";
    } else if (value == 2) {
        return "调拨出库";
    } else if (value == 3) {
        return "订单出库";
    } else if (value == 4) {
        return "其它出库";
    } else if (value == 5) {
        return "加工出库";
    } else if (value == 6) {
        return "批发出库";
    } else {
        return "未知出库类型";
    }

}

/* 布尔值转换
 *@param value
 * @returns
 */
function formatBoolean(value) {
    if (value == 1) {
        return "是";
    } else if (value == 0) {
        return "否";
    }
}

/**
 * 调整单状态
 * @param value
 * @returns {*}
 */
function reviewAdjustStatus(value) {
    if (value == 100) {
        return "草稿";
    } else if (value == 200) {
        return "驳回";
    } else if (value == 300) {
        return "审核通过";
    }
}

/**
 * 盘点调整类型
 * @param value
 * @returns {*}
 */
function reviewAdjustType(value) {
    if (value == 0) {
        return "无效调整";
    } else if (value == 1) {
        return "盘盈调整";
    } else if (value == 2) {
        return "盘亏调整";
    }
}

/**
 * 盘点单是否有差异
 * @param value
 */
function isDifference(value) {
    if (value) {
        return "有";
    } else {
        return "无";
    }
}

var chnNumChar = ["零", "一", "二", "三", "四", "五", "六", "七", "八", "九"];
var chnUnitChar = ["", "十", "百", "千"];

/**
 * 阿拉伯数字转化为中文
 * @param section
 * @returns {string}
 */
function numberToChinese(section) {
    var strIns = '', chnStr = '';
    var unitPos = 0;
    var zero = true;
    while (section > 0) {
        var v = section % 10;
        if (v === 0) {
            if (!zero) {
                zero = true;
                chnStr = chnNumChar[v] + chnStr;
            }
        } else {
            zero = false;
            strIns = chnNumChar[v];
            strIns += chnUnitChar[unitPos];
            chnStr = strIns + chnStr;
        }
        unitPos++;
        section = Math.floor(section / 10);
    }
    return chnStr;
}

/**
 * 交接单类型
 * @returns {*}
 */
function formatHandoverType(value) {
    if (value == 1) {
        return "自动";
    } else {
        return "人工";
    }
}

function formatPartnerOrderStatus(value) {
    if (value == 0) {
        return '取消';
    } else if (value == 50) {
        return "已拆单";
    }else if(value == 100){
        return "库存占用";
    }else if(value == 200){
        return "库存不足";
    }else if(value ==300){
        return "待补货";
    }else if(value ==400){
        return "待拣货";
    }else if(value == 450){
        return "已拣货";
    }else if(value == 500){
        return "报缺重检";
    }else if(value == 550){
        return "实物报缺";
    }else if(value ==600){
        return "质检完成";
    }else if(value == 650){
        return "已称重";
    }else if(value ==700){
        return "已出库";
    }

    return "";
}

function formatPartnerPickingOffStatus(value){
    //100拣选汇总(计划下架）200已打印300拣货中400拣货完成500质检完成600报缺重检700确认出库
    if(value == 100){
        return "待拣货";
    }else if(value == 200){
        return "已打印";
    }else if(value == 300){
        return "拣货中"
    }else if(value == 400){
        return "已拣货";
    }else if(value ==500){
        return "质检完成";
    }else if(value == 600){
        return "报缺重检";
    }else if(value == 700){
        return "已出库";
    }
    return "";
}