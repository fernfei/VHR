(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7486562a"],{5899:function(e,t){e.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(e,t,a){var r=a("1d80"),l=a("5899"),i="["+l+"]",o=RegExp("^"+i+i+"*"),s=RegExp(i+i+"*$"),n=function(e){return function(t){var a=String(r(t));return 1&e&&(a=a.replace(o,"")),2&e&&(a=a.replace(s,"")),a}};e.exports={start:n(1),end:n(2),trim:n(3)}},"58da":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{"font-family":"Arial"}},[a("div",{staticClass:"header"},[a("div",{staticStyle:{width:"600px"}},[a("el-input",{staticStyle:{width:"50%","margin-right":"10px"},attrs:{"prefix-icon":"el-icon-search",size:"small",clearable:"",disabled:e.keywordSearchDisabled,placeholder:"通过员工名搜索员工，回车键搜索..."},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchEmp(t)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary",size:"small",disabled:e.keywordSearchDisabled},on:{click:e.searchEmp}},[e._v("搜索")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.showSearchView}},[a("i",{staticClass:"fa fa-angle-double-down",attrs:{"aria-hidden":"true"}}),e._v(" 高级搜索")])],1),a("div",[a("el-upload",{staticStyle:{display:"inline-flex","margin-right":"10px"},attrs:{"on-error":e.onError,"on-success":e.onSuccess,"before-upload":e.beforeUpload,"show-file-list":!1,disabled:e.isImportDisabled,action:"/emp/basic/import"}},[a("el-button",{attrs:{size:"small",type:"success",disabled:e.isImportDisabled,icon:e.importButtonIcon}},[e._v(" "+e._s(e.importButtonText)+" ")])],1),a("el-button",{attrs:{size:"small",icon:"el-icon-download",type:"success"},on:{click:e.exportData}},[e._v(" 导出数据")]),a("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-plus"},on:{click:e.showAddEmp}},[e._v(" 添加员工")])],1)]),a("el-collapse-transition",[a("div",{directives:[{name:"show",rawName:"v-show",value:e.showRangeSearch,expression:"showRangeSearch"}],staticClass:"showRangeSearch"},[a("el-row",{staticStyle:{"margin-bottom":"20px"}},[a("el-col",{attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 政治面貌 ")]),a("el-select",{attrs:{size:"small",placeholder:"请选择政治面貌"},on:{"visible-change":e.getAllPoliticsStatus},model:{value:e.rangeSearch.politicId,callback:function(t){e.$set(e.rangeSearch,"politicId",t)},expression:"rangeSearch.politicId"}},e._l(e.allPoliticsStatus,(function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-col",{attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 民族 ")]),a("el-select",{attrs:{size:"small",placeholder:"请选择民族"},on:{"visible-change":e.getAllNations},model:{value:e.rangeSearch.nationId,callback:function(t){e.$set(e.rangeSearch,"nationId",t)},expression:"rangeSearch.nationId"}},e._l(e.allNations,(function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-col",{attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 职位 ")]),a("el-select",{attrs:{size:"small",placeholder:"请选择职位"},on:{"visible-change":e.getAllPositions},model:{value:e.rangeSearch.posId,callback:function(t){e.$set(e.rangeSearch,"posId",t)},expression:"rangeSearch.posId"}},e._l(e.allPositions,(function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-col",{attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 职称 ")]),a("el-select",{attrs:{size:"small",placeholder:"请选择职称"},on:{"visible-change":e.getAllJobLevels},model:{value:e.rangeSearch.jobLevelId,callback:function(t){e.$set(e.rangeSearch,"jobLevelId",t)},expression:"rangeSearch.jobLevelId"}},e._l(e.allJobLevels,(function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),a("el-row",[a("el-col",{staticStyle:{display:"flex"},attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 所属部门 ")]),a("el-popover",{attrs:{placement:"right",title:"请选择部门",width:"200",trigger:"click"}},[a("el-tree",{attrs:{data:e.allDepartment,"default-expand-all":"","node-key":"id","expand-on-click-node":!1,props:e.defaultProps},on:{"node-click":e.selectedDepartment}}),""===e.rangeSearch.departmentName?a("div",{ref:"department",staticClass:"emp-length",staticStyle:{width:"203px","line-height":"32px",display:"inline-block",height:"32px",border:"1px solid rgb(220,232,230)",color:"#C0C4CC","border-radius":"5px","padding-left":"10px"},attrs:{slot:"reference"},on:{click:e.initDepartment},slot:"reference",model:{value:e.rangeSearch.departmentName,callback:function(t){e.$set(e.rangeSearch,"departmentName",t)},expression:"rangeSearch.departmentName"}},[e._v(" 所属部门 ")]):a("div",{ref:"department",staticClass:"emp-length",staticStyle:{width:"203px","line-height":"32px",display:"inline-block",height:"32px",border:"1px solid rgb(220,232,230)","border-radius":"5px","padding-left":"10px"},attrs:{slot:"reference"},on:{click:e.initDepartment},slot:"reference",model:{value:e.rangeSearch.departmentName,callback:function(t){e.$set(e.rangeSearch,"departmentName",t)},expression:"rangeSearch.departmentName"}},[e._v(e._s(e.rangeSearch.departmentName))])],1)],1),a("el-col",{attrs:{span:6}},[a("el-tag",{attrs:{type:"",effect:"dark"}},[e._v(" 入职日期 ")]),a("el-date-picker",{staticStyle:{width:"330px"},attrs:{size:"small",type:"datetimerange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期",align:"right"},model:{value:e.rangeSearch.dateArray,callback:function(t){e.$set(e.rangeSearch,"dateArray",t)},expression:"rangeSearch.dateArray"}})],1),a("el-col",{attrs:{span:6}},[a("el-tag",{staticStyle:{"margin-right":"10px"},attrs:{type:"",effect:"dark"}},[e._v(" 聘用方式 ")]),a("el-radio",{attrs:{label:"劳动合同"},model:{value:e.rangeSearch.engageForm,callback:function(t){e.$set(e.rangeSearch,"engageForm",t)},expression:"rangeSearch.engageForm"}},[e._v("劳动合同")]),a("el-radio",{attrs:{label:"劳务合同"},model:{value:e.rangeSearch.engageForm,callback:function(t){e.$set(e.rangeSearch,"engageForm",t)},expression:"rangeSearch.engageForm"}},[e._v("劳务合同")])],1),a("el-col",{attrs:{span:6}},[a("el-button",{attrs:{size:"small"},on:{click:e.showSearchView}},[e._v(" 取消 ")]),a("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:e.advancedSearch}},[e._v("搜索")])],1)],1)],1)]),a("div",{staticClass:"table"},[a("el-table",{staticStyle:{width:"100%"},attrs:{size:"mini",data:e.employeeData,border:""},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{fixed:"",prop:"name",label:"员工名",width:"120"}}),a("el-table-column",{attrs:{prop:"gender",label:"性别",width:"50"}}),a("el-table-column",{attrs:{prop:"birthday",label:"生日",width:"200"}}),a("el-table-column",{attrs:{prop:"wedlock",label:"婚姻状况",width:"120"}}),a("el-table-column",{attrs:{prop:"nation.name",label:"民族",width:"120"}}),a("el-table-column",{attrs:{prop:"nativeplace",label:"籍贯",width:"120"}}),a("el-table-column",{attrs:{prop:"politicsstatus.name",label:"政治面貌",width:"120"}}),a("el-table-column",{attrs:{prop:"email",label:"邮箱",width:"200"}}),a("el-table-column",{attrs:{prop:"phone",label:"手机号码",width:"150"}}),a("el-table-column",{attrs:{prop:"address",label:"居住地址",width:"200"}}),a("el-table-column",{attrs:{prop:"department.name",label:"部门",width:"120"}}),a("el-table-column",{attrs:{prop:"jobLevel.name",label:"职称",width:"120"}}),a("el-table-column",{attrs:{prop:"position.name",label:"职位",width:"120"}}),a("el-table-column",{attrs:{prop:"engageform",label:"聘用形式",width:"120"}}),a("el-table-column",{attrs:{prop:"tiptopdegree",label:"最高学历",width:"120"}}),a("el-table-column",{attrs:{prop:"specialty",label:"专业",width:"200"}}),a("el-table-column",{attrs:{prop:"school",label:"毕业院校",width:"200"}}),a("el-table-column",{attrs:{prop:"begindate",label:"入职时间",width:"250"}}),a("el-table-column",{attrs:{prop:"workstate",label:"工作状态",width:"120"}}),a("el-table-column",{attrs:{prop:"workid",label:"工号",width:"120"}}),a("el-table-column",{attrs:{prop:"contractterm",label:"合同期限",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.contractterm)+"年")])]}}])}),a("el-table-column",{attrs:{prop:"conversiontime",label:"转正日期",width:"250"}}),a("el-table-column",{attrs:{prop:"notworkdate",label:"离职日期",width:"250"}}),a("el-table-column",{attrs:{prop:"begincontract",label:"合同起始时间",width:"250"}}),a("el-table-column",{attrs:{prop:"endcontract",label:"合同结束时间",width:"250"}}),a("el-table-column",{attrs:{prop:"workage",label:"工作年限",width:"120"}}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"170"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{staticStyle:{padding:"3px 0"},attrs:{type:"warning",size:"small"},on:{click:function(a){return e.showEditEmp(t.row)}}},[e._v("编辑")]),a("el-button",{staticStyle:{padding:"3px 0"},attrs:{type:"primary",size:"small"}},[e._v("查看高级资料")]),a("el-button",{staticStyle:{padding:"3px 0"},attrs:{type:"danger",size:"small"},on:{click:function(a){return e.deleteEmp(t.row)}}},[e._v("删除")])]}}])})],1),a("div",{staticClass:"total-page"},[a("div",[a("el-button",{attrs:{type:"danger",disabled:0===e.multipleSelection.length},on:{click:e.deleteEmpByIds}},[e._v("批量删除")])],1),a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.total},on:{"current-change":e.currentChange}})],1)],1),a("div",[a("el-dialog",{attrs:{title:e.OperationType+"用户信息",visible:e.dialogFormVisible,width:"80%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"empForm",attrs:{model:e.empForm,rules:e.rules,"label-width":"120px",size:"small",inline:""}},[a("el-form-item",{attrs:{label:"用户名",prop:"name"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"请输入用户名"},model:{value:e.empForm.name,callback:function(t){e.$set(e.empForm,"name","string"===typeof t?t.trim():t)},expression:"empForm.name"}})],1),a("el-form-item",{staticStyle:{width:"334px"},attrs:{label:"性别",prop:"gender"}},[a("el-radio-group",{model:{value:e.empForm.gender,callback:function(t){e.$set(e.empForm,"gender",t)},expression:"empForm.gender"}},[a("el-radio",{attrs:{label:"男"}},[e._v("男")]),a("el-radio",{attrs:{label:"女"}},[e._v("女")])],1)],1),a("el-form-item",{attrs:{label:"出生日期",prop:"birthday"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticClass:"emp-length",attrs:{type:"date",placeholder:"选择日期"},model:{value:e.empForm.birthday,callback:function(t){e.$set(e.empForm,"birthday",t)},expression:"empForm.birthday"}})],1)]),a("el-form-item",{attrs:{label:"政治面貌",prop:"politicid"}},[a("el-select",{attrs:{placeholder:"政治面貌"},on:{"visible-change":e.getAllPoliticsStatus},model:{value:e.empForm.politicid,callback:function(t){e.$set(e.empForm,"politicid",t)},expression:"empForm.politicid"}},e._l(e.allPoliticsStatus,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"民族",prop:"nationid"}},[a("el-select",{staticClass:"emp-length",attrs:{placeholder:"请选择民族"},on:{"visible-change":e.getAllNations},model:{value:e.empForm.nationid,callback:function(t){e.$set(e.empForm,"nationid",t)},expression:"empForm.nationid"}},e._l(e.allNations,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"籍贯",prop:"nativeplace"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"员工籍贯"},model:{value:e.empForm.nativeplace,callback:function(t){e.$set(e.empForm,"nativeplace",t)},expression:"empForm.nativeplace"}})],1),a("el-form-item",{attrs:{label:"电子邮箱",prop:"email"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"电子邮件地址"},model:{value:e.empForm.email,callback:function(t){e.$set(e.empForm,"email",t)},expression:"empForm.email"}})],1),a("el-form-item",{attrs:{label:"联系地址",prop:"address"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"联系地址"},model:{value:e.empForm.address,callback:function(t){e.$set(e.empForm,"address",t)},expression:"empForm.address"}})],1),a("el-form-item",{attrs:{label:"职位",prop:"posid"}},[a("el-select",{staticClass:"emp-length",attrs:{placeholder:"请选择职位"},on:{"visible-change":e.getAllPositions},model:{value:e.empForm.posid,callback:function(t){e.$set(e.empForm,"posid",t)},expression:"empForm.posid"}},e._l(e.allPositions,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"职称",prop:"joblevelid"}},[a("el-select",{staticClass:"emp-length",attrs:{placeholder:"请选择职称"},on:{"visible-change":e.getAllJobLevels},model:{value:e.empForm.joblevelid,callback:function(t){e.$set(e.empForm,"joblevelid",t)},expression:"empForm.joblevelid"}},e._l(e.allJobLevels,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"所属部门",prop:"departmentid"}},[a("el-popover",{attrs:{placement:"right",title:"请选择部门",width:"200",trigger:"click"}},[a("el-tree",{attrs:{data:e.allDepartment,"default-expand-all":"","node-key":"id","expand-on-click-node":!1,props:e.defaultProps},on:{"node-click":e.selectedDepartment}}),""===e.empForm.departmentName?a("div",{ref:"department",staticClass:"emp-length",staticStyle:{width:"203px",height:"32px",border:"1px solid rgb(220,232,230)",color:"#C0C4CC","border-radius":"5px","padding-left":"10px"},attrs:{slot:"reference"},on:{click:e.initDepartment},slot:"reference",model:{value:e.empForm.departmentName,callback:function(t){e.$set(e.empForm,"departmentName",t)},expression:"empForm.departmentName"}},[e._v(" 所属部门 ")]):a("div",{ref:"department",staticClass:"emp-length",staticStyle:{width:"203px",height:"32px",border:"1px solid rgb(220,232,230)","border-radius":"5px","padding-left":"10px"},attrs:{slot:"reference"},on:{click:e.initDepartment},slot:"reference",model:{value:e.empForm.departmentName,callback:function(t){e.$set(e.empForm,"departmentName",t)},expression:"empForm.departmentName"}},[e._v(e._s(e.empForm.departmentName))])],1)],1),a("el-form-item",{attrs:{label:"手机号码",prop:"phone"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"手机号码"},model:{value:e.empForm.phone,callback:function(t){e.$set(e.empForm,"phone",t)},expression:"empForm.phone"}})],1),a("el-form-item",{attrs:{label:"工号",prop:"workId"}},[a("el-input",{staticClass:"emp-length",attrs:{disabled:""},model:{value:e.empForm.workid,callback:function(t){e.$set(e.empForm,"workid",t)},expression:"empForm.workid"}})],1),a("el-form-item",{attrs:{label:"学历",prop:"tiptopdegree"}},[a("el-select",{staticClass:"emp-length",attrs:{placeholder:"最高学历"},model:{value:e.empForm.tiptopdegree,callback:function(t){e.$set(e.empForm,"tiptopdegree",t)},expression:"empForm.tiptopdegree"}},e._l(e.tiptopDegrees,(function(e,t){return a("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1),a("el-form-item",{attrs:{label:"毕业院校",prop:"school"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"毕业院校"},model:{value:e.empForm.school,callback:function(t){e.$set(e.empForm,"school",t)},expression:"empForm.school"}})],1),a("el-form-item",{attrs:{label:"专业名称",prop:"specialty"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"专业名称"},model:{value:e.empForm.specialty,callback:function(t){e.$set(e.empForm,"specialty",t)},expression:"empForm.specialty"}})],1),a("el-form-item",{attrs:{label:"入职日期",prop:"begindate"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticClass:"emp-length",attrs:{type:"date",placeholder:"选择日期"},model:{value:e.empForm.begindate,callback:function(t){e.$set(e.empForm,"begindate",t)},expression:"empForm.begindate"}})],1)]),a("el-form-item",{attrs:{label:"转正日期",prop:"conversiontime"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticClass:"emp-length",attrs:{type:"date",placeholder:"选择日期"},model:{value:e.empForm.conversiontime,callback:function(t){e.$set(e.empForm,"conversiontime",t)},expression:"empForm.conversiontime"}})],1)]),a("el-form-item",{attrs:{label:"合同起始时间",prop:"begincontract"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticClass:"emp-length",attrs:{type:"date",placeholder:"选择日期"},model:{value:e.empForm.begincontract,callback:function(t){e.$set(e.empForm,"begincontract",t)},expression:"empForm.begincontract"}})],1)]),a("el-form-item",{attrs:{label:"合同终止时间",prop:"endcontract"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticClass:"emp-length",attrs:{type:"date",placeholder:"选择日期"},model:{value:e.empForm.endcontract,callback:function(t){e.$set(e.empForm,"endcontract",t)},expression:"empForm.endcontract"}})],1)]),a("el-form-item",{attrs:{label:"身份证号码",prop:"idcard"}},[a("el-input",{staticClass:"emp-length",attrs:{placeholder:"身份证号码"},model:{value:e.empForm.idcard,callback:function(t){e.$set(e.empForm,"idcard","string"===typeof t?t.trim():t)},expression:"empForm.idcard"}})],1),a("el-form-item",{staticStyle:{width:"314px"},attrs:{label:"聘用形式",prop:"engageform"}},[a("el-radio-group",{model:{value:e.empForm.engageform,callback:function(t){e.$set(e.empForm,"engageform",t)},expression:"empForm.engageform"}},[a("el-radio",{attrs:{label:"劳动合同"}},[e._v("劳动合同")]),a("el-radio",{attrs:{label:"劳务合同"}},[e._v("劳务合同")])],1)],1),a("el-form-item",{staticStyle:{width:"354px"},attrs:{label:"婚姻状况",prop:"wedlock"}},[a("el-radio-group",{model:{value:e.empForm.wedlock,callback:function(t){e.$set(e.empForm,"wedlock",t)},expression:"empForm.wedlock"}},[a("el-radio",{attrs:{label:"已婚"}},[e._v("已婚")]),a("el-radio",{attrs:{label:"未婚"}},[e._v("未婚")]),a("el-radio",{attrs:{label:"离异"}},[e._v("离异")])],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.addEmp}},[e._v("确 定")])],1)],1)],1)],1)},l=[],i=(a("b0c0"),a("a9e3"),a("8ba4"),{name:"EmpBasic",data:function(){var e=function(e,t,a){var r=/^1[3|4|5|6|7|8][0-9]{9}$/;if(!t)return a(new Error("电话号码不能为空"));setTimeout((function(){Number.isInteger(+t)?r.test(t)?a():a(new Error("电话号码格式不正确")):a(new Error("请输入数字值"))}),100)};return{keywordSearchDisabled:!1,showRangeSearch:!1,rangeSearch:{politicId:"",nationId:"",posId:"",jobLevelId:"",dateArray:"",departmentId:"",engageForm:"",departmentName:"",type:""},importButtonText:"导入数据",importButtonIcon:"el-icon-upload2",isImportDisabled:!1,allDepartment:[],defaultProps:{children:"children",label:"name"},employeeData:[],total:0,multipleSelection:[],page:1,size:10,loading:!0,dialogFormVisible:!1,keywords:"",OperationType:"",tiptopDegrees:["博士","硕士","本科","大专","高中","初中","小学","其他"],allNations:[],allPositions:[],allJobLevels:[],allPoliticsStatus:[],engageform:"",wedlock:"",empForm:{name:"",gender:"",birthday:new Date,idcard:"",wedlock:"",nationid:"",nativeplace:"",politicid:"",email:"",phone:"",address:"",departmentid:"",departmentName:"",joblevelid:"",posid:"",engageform:"",tiptopdegree:"",specialty:"",school:"",begindate:new Date,workstate:"",workid:"",contractterm:"",conversiontime:new Date,notworkdate:"",begincontract:new Date,endcontrct:new Date,workage:""},rules:{name:[{required:!0,message:"必须填写员工名",trigger:"blur"},{min:2,max:4,message:"姓名在2~4字符之间",trigger:"blur"}],gender:[{required:!0,message:"必须选择性别",trigger:"change"}],birthday:[{required:!0,message:"必须选择出生日期",trigger:"change"}],politicid:[{required:!0,message:"必须选择政治面貌",trigger:"change"}],nationid:[{required:!0,message:"必须选择民族",trigger:"change"}],nativeplace:[{required:!0,message:"必须填写籍贯",trigger:"blur"}],email:[{required:!0,message:"必须填写邮箱",trigger:"blur"},{type:"email",message:"电子邮箱格式错误",trigger:"blur"}],address:[{required:!0,message:"必须填写现居住地址",trigger:"blur"}],posid:[{required:!0,message:"必须选择职位",trigger:"change"}],joblevelid:[{required:!0,message:"必须选择职称",trigger:"change"}],departmentid:[{required:!0,message:"必须选择所属部门",trigger:"change"}],phone:[{required:!0,validator:e,trigger:"blur"}],tiptopdegree:[{required:!0,message:"必须选择学历",trigger:"change"}],school:[{required:!0,message:"必须填写毕业院校",trigger:"blur"}],specialty:[{required:!0,message:"必须填写专业",trigger:"blur"}],begindate:[{required:!0,message:"必须选择入职日期",trigger:"change"}],conversiontime:[{required:!0,message:"必须选择转正日期",trigger:"change"}],begincontract:[{required:!0,message:"必须选择合同起始日期",trigger:"change"}],endcontract:[{required:!0,message:"必须选择合同终止日期",trigger:"change"}],idcard:[{required:!0,message:"必须填写身份证号码",trigger:"blur"},{pattern:/(^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}$)/,message:"请输入正确格式的身份证号码",trigger:"blur"}],engageform:[{required:!0,message:"必须选择聘用方式",trigger:"change"}],wedlock:[{required:!0,message:"必须选择婚姻状况",trigger:"change"}]}}},watch:{keywords:function(e){""===e&&this.initEmployee()}},mounted:function(){this.initEmployee()},methods:{deleteEmpByIds:function(){for(var e=this,t="?",a=0;a<this.multipleSelection.length;a++)t+="&ids="+this.multipleSelection[a].id+"&";this.deleteRequest("/emp/basic/many"+t).then((function(t){t&&e.initEmployee()}))},advancedSearch:function(){var e=this,t="",a="";""!=this.rangeSearch.dateArray&&(t=this.moment(this.rangeSearch.dateArray[0]).format("YYYY-MM-DD HH:mm:ss"),a=this.moment(this.rangeSearch.dateArray[1]).format("YYYY-MM-DD HH:mm:ss"));var r="?politicid="+this.rangeSearch.politicId+"&nationid="+this.rangeSearch.nationId+"&posid="+this.rangeSearch.posId+"&joblevelid="+this.rangeSearch.jobLevelId+"&departmentid="+this.rangeSearch.departmentId+"&engageform="+this.rangeSearch.engageForm+"&beginDate="+t+"&endDate="+a+"&page="+this.page+"&siz="+this.size;this.getRequest("/emp/basic/advancedSearch/"+r).then((function(t){if(t)return null!==t.object.data&&0!==t.object.data.length||0==t.object.total?(e.employeeData=t.object.data,e.total=t.object.total,void(e.rangeSearch.type="advanced")):(e.page=1,e.size=10,void e.advancedSearch());e.$message.error("查询失败！")}))},showSearchView:function(){this.showRangeSearch=!this.showRangeSearch,this.keywordSearchDisabled=!this.keywordSearchDisabled,this.rangeSearch={politicId:"",nationId:"",posId:"",jobLevelId:"",dateArray:"",departmentId:"",engageForm:"",departmentName:"",type:""},this.initEmployee()},beforeUpload:function(e){this.isDisabled=!0,this.importButtonText="正在上传",this.importButtonIcon="el-icon-loading"},onError:function(e,t,a){this.isDisabled=!1,this.importButtonText="导入数据",this.importButtonIcon="el-icon-upload2",this.initEmployee()},onSuccess:function(e,t,a){this.isDisabled=!1,this.importButtonText="导入数据",this.importButtonIcon="el-icon-upload2",this.initEmployee()},exportData:function(){window.open("/emp/basic/export","_parent")},initEmployee:function(){var e=this,t="";t=null===this.keywords||""===this.keywords?"/emp/basic/?page="+this.page+"&size="+this.size:"/emp/basic/?page="+this.page+"&size="+this.size+"&keywords="+this.keywords,this.getRequest(t).then((function(t){e.loading=!1,t&&(e.employeeData=t.object.data,e.total=t.object.total)}))},initWorkId:function(){var e=this;this.getRequest("/emp/basic/workid").then((function(t){t?e.empForm.workid=t.object:e.$message.error("工号加载失败！")}))},currentChange:function(e){this.page=e,(null===this.keywords||""===this.keywords)&&"advanced"===this.rangeSearch.type?this.advancedSearch():this.initEmployee()},showEditEmp:function(e){this.dialogFormVisible=!0,this.OperationType="编辑",this.empForm=e},deleteEmp:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.name+"】员工, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/emp/basic/"+e.id).then((function(e){e&&t.initEmployee()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},handleSelectionChange:function(e){this.multipleSelection=e},searchEmp:function(){this.initEmployee()},showAddEmp:function(){this.OperationType="添加",this.dialogFormVisible=!0,this.initWorkId()},addEmp:function(){var e=this;this.formatDate(),"添加"===this.OperationType?(console.log(this.$refs.empForm),this.$refs.empForm.validate((function(t){if(!t)return e.$message({message:"所有字段必须填写",type:"error",duration:500}),!1;e.postRequest("/emp/basic/",e.empForm).then((function(t){t&&(e.empForm={},e.dialogFormVisible=!1)}))}))):this.$refs.empForm.validate((function(t){if(!t)return e.$message({message:"所有字段必须填写",type:"error",duration:500}),!1;e.putRequest("/emp/basic/",e.empForm).then((function(t){t&&(e.empForm={},e.initEmployee(),e.dialogFormVisible=!1)}))}))},formatDate:function(){this.empForm.birthday=this.moment(this.empForm.birthday).format("YYYY-MM-DD HH:mm:ss"),this.empForm.begindate=this.moment(this.empForm.begindate).format("YYYY-MM-DD HH:mm:ss"),this.empForm.conversiontime=this.moment(this.empForm.conversiontime).format("YYYY-MM-DD HH:mm:ss"),this.empForm.begincontract=this.moment(this.empForm.begincontract).format("YYYY-MM-DD HH:mm:ss"),this.empForm.endcontract=this.moment(this.empForm.endcontract).format("YYYY-MM-DD HH:mm:ss")},initDepartment:function(){var e=this;window.sessionStorage.getItem("departments")?(console.log("本地获取数据"),this.allDepartment=JSON.parse(window.sessionStorage.getItem("departments"))):(console.log("本地没有数据开始去服务端获取"),this.getRequest("/emp/basic/departments/").then((function(t){t&&(e.allDepartment=t.object,window.sessionStorage.setItem("departments",JSON.stringify(t.object)))})))},getAllNations:function(e){var t=this;window.sessionStorage.getItem("nations")?(console.log("本地获取数据"),this.allNations=JSON.parse(window.sessionStorage.getItem("nations"))):(console.log("本地没有数据开始去服务端获取"),e&&this.getRequest("/emp/basic/nations/").then((function(e){e&&(t.allNations=e.object,window.sessionStorage.setItem("nations",JSON.stringify(e.object)))})))},getAllPositions:function(e){var t=this;window.sessionStorage.getItem("positions")?(console.log("本地获取数据"),this.allPositions=JSON.parse(window.sessionStorage.getItem("positions"))):(console.log("本地没有数据开始去服务端获取"),e&&this.getRequest("/emp/basic/positions/").then((function(e){e&&(t.allPositions=e.object,window.sessionStorage.setItem("positions",JSON.stringify(e.object)))})))},getAllJobLevels:function(e){var t=this;window.sessionStorage.getItem("joblevels")?(console.log("本地获取数据"),this.allJobLevels=JSON.parse(window.sessionStorage.getItem("joblevels"))):(console.log("本地没有数据开始去服务端获取"),e&&this.getRequest("/emp/basic/joblevels/").then((function(e){e&&(t.allJobLevels=e.object,window.sessionStorage.setItem("joblevels",JSON.stringify(e.object)))})))},getAllPoliticsStatus:function(e){var t=this;window.sessionStorage.getItem("politicsstatus")?(console.log("本地获取数据"),this.allPoliticsStatus=JSON.parse(window.sessionStorage.getItem("politicsstatus"))):(console.log("本地没有数据开始去服务端获取"),e&&this.getRequest("/emp/basic/politicsstatus/").then((function(e){e&&(t.allPoliticsStatus=e.object,window.sessionStorage.setItem("politicsstatus",JSON.stringify(e.object)))})))},selectedDepartment:function(e){this.empForm.departmentName=e.name,this.empForm.departmentid=e.id,this.rangeSearch.departmentName=e.name,this.rangeSearch.departmentId=e.id,this.$refs.department.click()}}}),o=i,s=(a("aacc"),a("2877")),n=Object(s["a"])(o,r,l,!1,null,"f9c7ec1e",null);t["default"]=n.exports},"5e89":function(e,t,a){var r=a("861d"),l=Math.floor;e.exports=function(e){return!r(e)&&isFinite(e)&&l(e)===e}},8759:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 高级资料 ")])},l=[],i={name:"EmpAdv"},o=i,s=a("2877"),n=Object(s["a"])(o,r,l,!1,null,"3cb7796b",null);t["default"]=n.exports},"8ba4":function(e,t,a){var r=a("23e7"),l=a("5e89");r({target:"Number",stat:!0},{isInteger:l})},"8ddb":function(e,t,a){},a9e3:function(e,t,a){"use strict";var r=a("83ab"),l=a("da84"),i=a("94ca"),o=a("6eeb"),s=a("5135"),n=a("c6b6"),c=a("7156"),p=a("c04e"),m=a("d039"),d=a("7c73"),g=a("241c").f,h=a("06cf").f,u=a("9bf2").f,b=a("58a8").trim,f="Number",v=l[f],w=v.prototype,y=n(d(w))==f,k=function(e){var t,a,r,l,i,o,s,n,c=p(e,!1);if("string"==typeof c&&c.length>2)if(c=b(c),t=c.charCodeAt(0),43===t||45===t){if(a=c.charCodeAt(2),88===a||120===a)return NaN}else if(48===t){switch(c.charCodeAt(1)){case 66:case 98:r=2,l=49;break;case 79:case 111:r=8,l=55;break;default:return+c}for(i=c.slice(2),o=i.length,s=0;s<o;s++)if(n=i.charCodeAt(s),n<48||n>l)return NaN;return parseInt(i,r)}return+c};if(i(f,!v(" 0o1")||!v("0b1")||v("+0x1"))){for(var S,F=function(e){var t=arguments.length<1?0:e,a=this;return a instanceof F&&(y?m((function(){w.valueOf.call(a)})):n(a)!=f)?c(new v(k(t)),a,F):k(t)},x=r?g(v):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),I=0;x.length>I;I++)s(v,S=x[I])&&!s(F,S)&&u(F,S,h(v,S));F.prototype=w,w.constructor=F,o(l,f,F)}},aacc:function(e,t,a){"use strict";var r=a("8ddb"),l=a.n(r);l.a}}]);
//# sourceMappingURL=chunk-7486562a.67f00db2.js.map