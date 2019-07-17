var reviewId, reviewTaskId;
var reviewPager;
var reviewStatusList;
var rightAllList = new Array();  //右侧所有数据
var rightSelected = new Array(); //右侧已选中的行
var rightCanceled = new Array(); //右侧已删除的行
var leftAllList = new Array();   //左侧所有数据
var leftSelected = new Array();  //左侧已选中的行
var leftCanceled = new Array();  //左侧已删除的行
var reviewTaskIdTemp;
var reviewTaskStatusTemp;

$(document).ready(function () {
    reviewPager = new Pager("#reviewList", "review/page");

    $('#createTimeBegin').datetimebox({value : formatStartDate(new Date())});
    $('#createTimeEnd').datetimebox({value : formatEndDate(new Date())});

    initStatus();
    onReviewTaskClose();

    $("#reviewTaskWindow").window({
        modal:true,closed:true,resizable:false,collapsible:false,minimizable:false,maximizable:false,
        href: 'review/reviewTaskList?warehouseId=' + warehouseId
    });
});

function initStatus() {
    client_get("review/list-review-status",
        function (result) {
            reviewStatusList = result;
            combobox_init("#reviewStatus", result, {"key": -1, "value": "全部"});
            doSearchReview();
        });
}

//查询数据
function doSearchReview(pageNumber, pageSize) {
    var data = dealParamToReview();
    reviewPager.search(data, pageNumber, pageSize);
}
function dealParamToReview() {
    var data = {};
    var reviewWayValue = $("#reviewWayValue").val().trim();
    if (reviewWayValue != "") {
        var reviewWay = $("#reviewWay").val().trim();
        data[reviewWay] = reviewWayValue;
    }
    var createTimeBegin = $("#createTimeBegin").val();
    var createTimeEnd = $("#createTimeEnd").val();
    if (createTimeBegin != "") {
        data.createTimeBegin = createTimeBegin;
    }
    if (createTimeEnd != "") {
        data.createTimeEnd = createTimeEnd;
    }
    var isDifference = $("#isDifference").val();
    if (isDifference != "") {
        data.isDifference = isDifference;
    }
    var reviewStatus = $("#reviewStatus").val();
    if (reviewStatus != "-1") {
        data.status = reviewStatus;
    }
    return data;
}

function formatReviewStatus(val, row) {
    for (var i in reviewStatusList) {
        if (val == reviewStatusList[i].key) {
            return reviewStatusList[i].value;
        }
    }
    return "";
};

function formatGoodsCode(val, row) {
    return row.goodsCode + " / " + row.barCode;
};

function realDifferenceCountStyler(value, row, index) {
    if (value > 0){
        return 'background-color:#00cc33';
    } else if(value < 0){
        return 'background-color:#ff0000';
    }
}

function addReviewByLocation() {
    $("#reviewAddWindow").window({
        modal: true, closed: true, resizable: false, collapsible: false, minimizable: false, maximizable: false,
        iconCls: 'icon-save', href: 'review/reviewAddByLocation?warehouseId=' + warehouseId
    });
    $("#reviewAddWindow").window("open");
    if (rightAllList.length > 0) {
        rightAllList = [];
    }
    if (rightSelected.length > 0) {
        rightSelected = [];
    }
    if (rightCanceled.length > 0) {
        rightCanceled = [];
    }
    if (leftAllList.length > 0) {
        leftAllList = [];
    }
    if (leftSelected.length > 0) {
        leftSelected = [];
    }
    if (leftCanceled.length > 0) {
        leftCanceled = [];
    }
    $('#warehouseAreaId').combobox('clear');
    $('#tunnel').combobox('clear');
    $("#reviewLocationQueryDataGrid").datagrid("loadData", {total: 0, rows: []});
    $("#reviewLocationAddDataGrid").datagrid("loadData", {total: 0, rows: []});
    $("#memoText").textbox("setValue", "");
    $("#locationCount").textbox("setValue", "");
    $("#locationCodesStr").textbox("setValue", "");
    $('#locationCountSpan').html("0");
}

function addReviewBySku() {
    $("#reviewAddWindow").window({
        modal: true, closed: true, resizable: false, collapsible: false, minimizable: false, maximizable: false,
        iconCls: 'icon-save', href: 'review/reviewAddBySku?warehouseId=' + warehouseId
    });
    $("#reviewAddWindow").window("open");
    if (rightAllList.length > 0) {
        rightAllList = [];
    }
    if (rightSelected.length > 0) {
        rightSelected = [];
    }
    if (rightCanceled.length > 0) {
        rightCanceled = [];
    }
    if (leftAllList.length > 0) {
        leftAllList = [];
    }
    if (leftSelected.length > 0) {
        leftSelected = [];
    }
    if (leftCanceled.length > 0) {
        leftCanceled = [];
    }
    $('#warehouseAreaId').combobox('clear');
    $("#reviewLocationQueryDataGrid").datagrid("loadData", {total: 0, rows: []});
    $("#reviewLocationAddDataGrid").datagrid("loadData", {total: 0, rows: []});
    $("#memoText").textbox("setValue", "");
    $("#goodsCount").textbox("setValue", "");
    $('#goodsCountSpan').html("0");
}

function openReplayReviewWindow() {
    var review = $("#reviewList").datagrid("getSelected");
    if (review === undefined || review === null) {
        $.messager.alert('错误', "请选择盘点单据");
        return;
    } else if (review.status != "300") {
        $.messager.alert('错误', "所选行不为待确认单据");
        return;
    }
    $("#replayReviewWindow").window("open");
}

function replayReview() {
    var replayType = $("#replayType").combobox('getValue');
    if (replayType === undefined || replayType === null) {
        $("#replayReviewWindow").window("close");
        $.messager.alert('错误', "请选择复盘类型");
        return;
    }
    // data.replayType = replayType;
    var review = $("#reviewList").datagrid("getSelected");
    var data = {
        replayType: replayType,
        reviewId: review.reviewId
    };
    $.messager.progress({title: '执行中', msg: '发起复盘中...请勿刷新或关闭，耐心等待～'});
    client_post("review/replay-review", data,
        null, function (result) {
            $.messager.progress('close');
            $("#replayReviewWindow").window("close");
            doSearchReview();
        });
}

function checkReview() {
    var review = $("#reviewList").datagrid("getSelected");
    if (review === undefined || review === null) {
        $.messager.alert('错误', "请选择盘点单据");
        return;
    } else if (review.status != "300") {
        $.messager.alert('错误', "所选行不为待确认单据");
        return;
    }
    $.messager.confirm('确认', '您确认要执行确认盘点操作吗？', function (r) {
        if (r) {
            $.messager.progress({title: '执行中', msg: '发起确认盘点中...请勿刷新或关闭，耐心等待～'});
            client_post("review/checkReview", review.reviewId,
                null, function (result) {
                    $.messager.progress('close');
                    $("#replayReviewWindow").window("close");
                    doSearchReview();
                });
        }
    });
}

function cancelReview() {
    var review = $("#reviewList").datagrid("getSelected");
    if (review === undefined || review === null) {
        $.messager.alert('错误', "请选择盘点单据");
        return;
    } else if (review.status == "200") {
        $.messager.alert('错误', "盘点中无法取消");
        return;
    } else if (review.status == "500") {
        $.messager.alert('错误', "已被取消单据，不可操作");
        return;
    } else if (review.status == "400") {
        $.messager.alert('错误', "已完成单据，不可操作");
        return;
    }
    $.messager.confirm('确认', '您确认要执行取消盘点操作吗？', function (r) {
        if (r) {
            var data = {
                reviewId: review.reviewId
            };
            $.messager.progress({title: '执行中', msg: '发起取消盘点中...请勿刷新或关闭，耐心等待～'});
            client_post("review/cancelReview", data,
                null, function (result) {
                    $.messager.progress('close');
                    $("#replayReviewWindow").window("close");
                    doSearchReview();
                });
        }
    });
}

function formatReviewCode(val, row) {
    return "<a href=\"javaScript:showReviewTask('" + row.reviewId + "')\" class=\"easyui-linkbutton\">" + val + "</a>";
};


//盘点任务 --------------------------------------------------------------
//打开盘点任务窗口

function showReviewTask(reviewId) {
    debugger;
    $.reviewId = reviewId;
    $("#reviewTaskWindow").window("open");
    $('#reviewTaskWindow').window('refresh');
}

function onReviewTaskClose() {
    $('#reviewTaskWindow').window({
        onBeforeClose:function(){
            doSearchReview();
        }
    });
}



















