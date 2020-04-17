(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ce79652a"],{"13b0":function(e,t,a){},1435:function(e,t,a){"use strict";var n=a("e689"),i=a.n(n);i.a},"1fe7":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 系统管理 ")])},i=[],s={name:"SysCfg"},l=s,o=a("2877"),r=Object(o["a"])(l,n,i,!1,null,"23cce413",null);t["default"]=r.exports},"418a":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[a("div",{staticClass:"searchBox"},[a("el-input",{staticClass:"searchUser",attrs:{placeholder:"仅展示部分用户,可以通过搜索用户名来展示用户...","prefix-icon":"el-icon-search",size:"small"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchUser(t)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),a("el-button",{staticClass:"buttonUser",attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:e.searchUser}},[e._v("搜索")])],1),a("div",{staticClass:"user"},e._l(e.userData,(function(t,n){return a("el-card",{key:n,staticClass:"box-card"},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[e._v(e._s(t.name))]),a("el-button",{staticStyle:{float:"right",padding:"3px 0"},attrs:{type:"danger",icon:"el-icon-delete"},on:{click:function(a){return e.deleteUserById(t)}}})],1),a("div",{staticClass:"user-info"},[a("div",{staticClass:"user-image-info"},[a("el-image",{staticClass:"userface",attrs:{src:t.userface,alt:t.name}})],1),a("div",{staticClass:"user-text-info"},[a("div",[a("span",[e._v("用户: "+e._s(t.name))])]),a("div",[a("span",[e._v("手机: "+e._s(t.phone))])]),a("div",[a("span",[e._v("电话: "+e._s(t.telephone))])]),a("div",[a("span",[e._v("地址: "+e._s(t.address))])]),a("div",[a("span",[e._v("状态: "),a("el-tooltip",{attrs:{content:t.enabled?"开启":"禁用",placement:"top"}},[a("el-switch",{attrs:{"active-color":"#13ce66","inactive-color":"#ff4949"},on:{change:function(a){return e.changeEnabled(t)}},model:{value:t.enabled,callback:function(a){e.$set(t,"enabled",a)},expression:"user.enabled"}})],1)],1)]),a("div",[a("span",[e._v("角色: "),e._l(t.roles,(function(n){return a("el-tag",{key:n.id,staticStyle:{"margin-right":"4px",display:"inline-block"},attrs:{type:"success",closable:""},on:{close:function(a){return e.deleteRoleById(t,n.id)}}},[e._v(e._s(n.namezh))])})),a("el-popover",{attrs:{placement:"right",width:"200",trigger:"click"},on:{show:function(a){return e.showRoles(t)},hide:function(a){return e.hideRoles(t)}}},[a("div",{staticStyle:{"font-size":"15px","margin-bottom":"5px"}},[e._v("角色列表")]),a("el-select",{attrs:{multiple:"",filterable:"","allow-create":"","default-first-option":"",placeholder:"请选择角色"},model:{value:e.selectRoles,callback:function(t){e.selectRoles=t},expression:"selectRoles"}},e._l(e.allRoles,(function(e){return a("el-option",{key:e.id,attrs:{label:e.namezh,value:e.id}})})),1),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{slot:"reference",type:"text",icon:"el-icon-more",disabled:e.disabled},on:{click:e.initRoles},slot:"reference"})],1)],2)]),a("div",[a("span",[e._v("备注: "+e._s(t.remark))])])])])])})),1)])},i=[],s=(a("4160"),a("a434"),a("b0c0"),a("d3b7"),a("25f0"),a("159b"),{name:"SysHr",data:function(){return{userData:[],allRoles:[],selectRoles:[],keywords:"",disabled:!1,loading:!0}},mounted:function(){this.initUser()},watch:{keywords:function(e){""===e&&this.initUser()}},methods:{initUser:function(){var e=this;this.getRequest("/system/hr/").then((function(t){e.loading=!1,t?e.userData=t.object:e.$message.error("加载用户失败！")}))},changeEnabled:function(e){this.postRequest("/system/hr/",e)},initRoles:function(){var e=this;this.disabled=!0,this.getRequest("/system/basic/permiss/").then((function(t){t?e.allRoles=t.object:e.$message.error("加载角色信息失败！")}))},showRoles:function(e){var t=this;this.selectRoles=[],e.roles.forEach((function(e){t.selectRoles.push(e.id)}))},hideRoles:function(e){var t=this;this.disabled=!1;var a=[];if(e.roles.forEach((function(e){a.push(e.id)})),a.toString()!==this.selectRoles.toString()){var n="/system/hr/?hrid="+e.id,i="";this.selectRoles.forEach((function(e){i+="&rids="+e+"&"})),this.putRequest(n+i).then((function(e){e&&t.initUser()}))}},deleteRoleById:function(e,t){var a="?hrid="+e.id+"&rid="+t;this.deleteRequest("/system/hr/"+a).then((function(a){if(a)for(var n=0;n<e.roles.length;n++)e.roles[n].id==t&&e.roles.splice(n,1)}))},searchUser:function(){var e=this;this.keywords?this.getRequest("/system/hr/?keywords="+this.keywords).then((function(t){t?e.userData=t.object:e.$message.error("查询用户失败!")})):this.$message.error("搜索框不能为空！")},deleteUserById:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.name+"】用户, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/system/hr/"+e.id).then((function(a){if(a)for(var n=0;n<t.userData.length;n++)t.userData[n].id===e.id&&t.userData.splice(n,1)}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))}}}),l=s,o=(a("8939"),a("2877")),r=Object(o["a"])(l,n,i,!1,null,"0b93ad89",null);t["default"]=r.exports},4323:function(e,t,a){"use strict";var n=a("8af2"),i=a.n(n);i.a},"48bf":function(e,t,a){"use strict";var n=a("95be"),i=a.n(n);i.a},"4de4":function(e,t,a){"use strict";var n=a("23e7"),i=a("b727").filter,s=a("1dde"),l=a("ae40"),o=s("filter"),r=l("filter");n({target:"Array",proto:!0,forced:!o||!r},{filter:function(e){return i(this,e,arguments.length>1?arguments[1]:void 0)}})},6644:function(e,t,a){},"6fa4":function(e,t,a){},"778d":function(e,t,a){"use strict";var n=a("13b0"),i=a.n(n);i.a},8608:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 初始化数据库 ")])},i=[],s={name:"SysInit"},l=s,o=a("2877"),r=Object(o["a"])(l,n,i,!1,null,"5fd3d133",null);t["default"]=r.exports},"864e":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"searchBox"},[a("el-input",{staticClass:"searchUser",attrs:{clearable:"",placeholder:"可以通过搜索用户名来查询用户的操作记录...","prefix-icon":"el-icon-search",size:"small"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchUser(t)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),a("el-button",{staticClass:"buttonUser",attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:e.searchLog}},[e._v("搜索")])],1),a("div")]),a("div",[a("el-table",{staticStyle:{width:"40%"},attrs:{data:e.logData,stripe:""}},[a("el-table-column",{attrs:{prop:"id",label:"编号",width:"100"}}),a("el-table-column",{attrs:{prop:"hr.name",label:"操作员",width:"180"}}),a("el-table-column",{attrs:{prop:"operate",label:"操作内容",width:"230"}}),a("el-table-column",{attrs:{prop:"adddate",label:"操作日期",width:"200"}})],1)],1),a("div",{staticStyle:{"margin-top":"20px"}},[a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.total},on:{"current-change":e.currentChange}})],1)])},i=[],s={name:"SysLog",data:function(){return{keywords:"",page:1,size:10,logData:[],total:0}},watch:{keywords:function(e){null!==e&&""!==e||this.initLog(this.page,this.size)}},mounted:function(){this.initLog(this.page,this.size)},methods:{initLog:function(e,t){var a=this;null===this.keywords||""===this.keywords?this.getRequest("/sys/log/?page="+e+"&size="+t).then((function(e){e&&(a.logData=e.object.data,a.total=e.object.total)})):this.getRequest("/sys/log/?page="+e+"&size="+t+"&keywords="+this.keywords).then((function(e){e&&(a.logData=e.object.data)}))},searchLog:function(){this.initLog(this.page,this.size)},currentChange:function(e){this.initLog(e,this.size)}}},l=s,o=(a("48bf"),a("2877")),r=Object(o["a"])(l,n,i,!1,null,"091d2d6d",null);t["default"]=r.exports},8939:function(e,t,a){"use strict";var n=a("6fa4"),i=a.n(n);i.a},"8af2":function(e,t,a){},"8d67":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-tabs",{staticStyle:{"margin-top":"20px"},attrs:{type:"card"},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"部门管理",name:"depname"}},[a("dep-mana")],1),a("el-tab-pane",{attrs:{label:"职位管理",name:"posmana"}},[a("pos-mana")],1),a("el-tab-pane",{attrs:{label:"职称管理",name:"joblevel"}},[a("job-level-mana")],1),a("el-tab-pane",{attrs:{label:"奖惩规则",name:"ec-mana"}},[a("ec-mana")],1),a("el-tab-pane",{attrs:{label:"权限组",name:"permissmana"}},[a("permiss-mana")],1)],1)],1)},i=[],s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"tree"},[a("el-input",{attrs:{"prefix-icon":"el-icon-search",size:"small",placeholder:"请输入部门名称进行搜索..."},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),a("el-tree",{ref:"tree",staticStyle:{"margin-top":"10px"},attrs:{data:e.deps,props:e.defaultProps,"filter-node-method":e.filterNode,"expand-on-click-node":!1},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.node,i=t.data;return a("span",{staticClass:"custom-tree-node"},[a("span",[e._v(e._s(n.label))]),a("span",[a("el-button",{staticStyle:{padding:"3px 0"},attrs:{type:"primary"},on:{click:function(t){return e.showAppendDepartment(i)}}},[e._v(" 添加部门 ")]),a("el-button",{staticStyle:{padding:"3px 0"},attrs:{type:"danger"},on:{click:function(t){return e.removeDepartment(n,i)}}},[e._v(" 删除部门 ")])],1)])}}])})],1),a("div",[a("el-dialog",{attrs:{title:"添加部门",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{attrs:{model:e.form}},[a("el-form-item",{attrs:{label:"上级部门"}},[a("el-select",{attrs:{disabled:"",placeholder:"请选择上级部门",size:"small"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}},[a("el-option",{attrs:{value:e.form.name}})],1)],1),a("el-form-item",{attrs:{label:"部门名称"}},[a("el-input",{staticStyle:{width:"23.5%"},attrs:{autocomplete:"off",size:"small"},model:{value:e.form.depName,callback:function(t){e.$set(e.form,"depName",t)},expression:"form.depName"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(t){return e.appendDepartment()}}},[e._v("确 定")])],1)],1)],1)])},l=[],o=(a("4de4"),a("c975"),a("a434"),a("b0c0"),{name:"DepMana",data:function(){return{filterText:"",deps:[],defaultProps:{children:"children",label:"name"},dialogFormVisible:!1,form:{name:"",depName:"",id:0},loading:!0}},watch:{filterText:function(e){this.$refs.tree.filter(e)}},methods:{filterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},initDepartment:function(){var e=this;this.getRequest("/system/basic/department/").then((function(t){e.loading=!1,t&&(e.deps=t.object)}))},showAppendDepartment:function(e){this.dialogFormVisible=!0,Object.assign(this.form,e)},removeDepartment:function(e,t){var a=this;this.$confirm("此操作将永久删除【"+t.name+"】部门, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){a.deleteRequest("/system/basic/department/"+t.id).then((function(e){e&&a.removeRefresh(a.deps,t)}))})).catch((function(){a.$message({type:"info",message:"已取消删除"})})),console.log(e),console.log(t)},appendDepartment:function(){var e=this;this.dialogFormVisible=!1;var t={name:"",parentid:0};t.name=this.form.depName,t.parentid=this.form.id,this.postRequest("/system/basic/department/",t).then((function(t){t&&e.addRefresh(e.deps,t)})),this.form.depName=""},addRefresh:function(e,t){for(var a=0;a<e.length;a++){if(e[a].id==t.object.parentid)return void e[a].children.push(t.object);this.addRefresh(e[a].children,t)}},removeRefresh:function(e,t){for(var a=0;a<e.length;a++){if(e[a].id==t.parentid){for(var n=0;n<e[a].children.length;n++)e[a].children[n].id==t.id&&e[a].children.splice(n,1);return}this.removeRefresh(e[a].children,t)}}},mounted:function(){this.initDepartment()}}),r=o,c=(a("4323"),a("2877")),d=Object(c["a"])(r,s,l,!1,null,"6e201591",null),u=d.exports,m=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 奖惩规则 ")])},f=[],p={name:"EcMana"},h=p,b=Object(c["a"])(h,m,f,!1,null,"45fe8b3e",null),v=b.exports,g=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[a("div",[a("el-input",{staticStyle:{width:"375px"},attrs:{size:"small",placeholder:"添加职称","prefix-icon":"el-icon-plus"},model:{value:e.addJobData.name,callback:function(t){e.$set(e.addJobData,"name",t)},expression:"addJobData.name"}}),a("el-select",{staticStyle:{"margin-left":"10px"},attrs:{placeholder:"职称等级",size:"small"},model:{value:e.addJobData.titlelevel,callback:function(t){e.$set(e.addJobData,"titlelevel",t)},expression:"addJobData.titlelevel"}},e._l(e.titlelevels,(function(e,t){return a("el-option",{key:t+"",attrs:{label:e,value:e}})})),1),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{size:"small",icon:"el-icon-plus",type:"primary"},on:{click:e.addJobLevel}},[e._v("添加职位")]),a("el-table",{staticStyle:{width:"70%","margin-top":"30px"},attrs:{data:e.jobLevelData,border:"",stripe:""},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"80"}}),a("el-table-column",{attrs:{prop:"name",label:"职称名称",width:"230"}}),a("el-table-column",{attrs:{prop:"titlelevel",label:"职称等级",width:"230"}}),a("el-table-column",{attrs:{prop:"createdate",label:"创建时间"}}),a("el-table-column",{attrs:{label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.enabled?a("el-tag",{staticClass:"enabled",attrs:{type:"success"},on:{click:function(a){return e.changeEnabled(t.row)}}},[e._v("已启用")]):a("el-tag",{staticClass:"enabled",attrs:{type:"danger"},on:{click:function(a){return e.changeEnabled(t.row)}}},[e._v("已禁止")])]}}])}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.deleteJobLevel(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1),a("div",[a("el-dialog",{attrs:{title:"编辑职位名称",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",[a("el-tag",{attrs:{effect:"dark"}},[e._v("职称名称")]),a("el-input",{staticStyle:{width:"40%","margin-left":"10px"},attrs:{size:"small",placeholder:"请输入内容"},model:{value:e.updateData.name,callback:function(t){e.$set(e.updateData,"name",t)},expression:"updateData.name"}}),a("el-select",{staticStyle:{"margin-left":"10px"},attrs:{placeholder:"职称等级",size:"small"},model:{value:e.updateData.titlelevel,callback:function(t){e.$set(e.updateData,"titlelevel",t)},expression:"updateData.titlelevel"}},e._l(e.titlelevels,(function(e,t){return a("el-option",{key:t+"",attrs:{label:e,value:e}})})),1)],1),a("div",[a("el-tag",{attrs:{effect:"dark"}},[e._v("是否启用")]),a("el-switch",{staticStyle:{"margin-left":"10px"},attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":e.updateData.text()},model:{value:e.updateData.enabled,callback:function(t){e.$set(e.updateData,"enabled",t)},expression:"updateData.enabled"}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.updateJobLevel}},[e._v("确 定")])],1)])],1),a("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0===e.multipleSelection.length},on:{click:e.deleteJobLevelByIds}},[e._v("批量删除")])],1)},y=[],k=(a("4160"),a("159b"),{name:"JobLevelMana",data:function(){return{multipleSelection:[],jobLevelData:[],updateData:{name:"",titlelevel:"",enabled:!1,text:function(){return this.enabled?"已启用":"已禁止"}},addJobData:{name:"",titlelevel:""},titlelevels:[],dialogVisible:!1,loading:!0}},mounted:function(){this.initJobLevel(),this.initTitleLevel()},methods:{initJobLevel:function(){var e=this;this.getRequest("/system/basic/joblevel/").then((function(t){e.loading=!1,t?(e.jobLevelData=t.object,e.addJobData.name="",e.addJobData.titlelevel=""):e.$message.error("加载职称信息失败！")}))},initTitleLevel:function(){var e=this;this.getRequest("/system/basic/joblevel/titlelevel").then((function(t){t?e.titlelevels=t.object:e.$message.error("加载职称级别失败！")}))},addJobLevel:function(){var e=this;this.addJobData.name&&this.addJobData.titlelevel?this.postRequest("/system/basic/joblevel/",this.addJobData).then((function(t){t&&e.initJobLevel()})):this.$message.error("职称或者职称等级有一项为空！")},deleteJobLevel:function(e,t){var a=this;this.$confirm("此操作将永久删除【"+t.name+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){a.deleteRequest("/system/basic/joblevel/"+t.id).then((function(e){e&&a.initJobLevel()}))})).catch((function(){a.$message({type:"info",message:"已取消删除"})}))},deleteJobLevelByIds:function(){var e=this,t="?";this.multipleSelection.forEach((function(e){t+="ids="+e.id+"&"})),this.deleteRequest("/system/basic/joblevel/multi/"+t).then((function(t){t&&e.initJobLevel()}))},handleEdit:function(e,t){this.dialogVisible=!0,Object.assign(this.updateData,t)},updateJobLevel:function(){var e=this;this.putRequest("/system/basic/joblevel/",this.updateData).then((function(t){t&&(e.initJobLevel(),e.dialogVisible=!1)}))},handleSelectionChange:function(e){this.multipleSelection=e},changeEnabled:function(e){var t=this,a={id:e.id,name:e.name,titlelevel:e.titlelevel,enabled:!e.enabled};e&&this.putRequest("/system/basic/joblevel/",a).then((function(e){e&&t.initJobLevel()}))}}}),x=k,_=(a("1435"),Object(c["a"])(x,g,y,!1,null,"31271320",null)),w=_.exports,R=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[a("div",{staticClass:"permissHead"},[a("el-input",{staticStyle:{width:"80px"},attrs:{disabled:!0,size:"small"},model:{value:e.default_value,callback:function(t){e.default_value=t},expression:"default_value"}}),a("el-input",{staticClass:"inputStyle",attrs:{placeholder:"请输入角色的英文名",size:"small"},model:{value:e.role.name,callback:function(t){e.$set(e.role,"name",t)},expression:"role.name"}}),a("el-input",{staticClass:"inputStyle",attrs:{placeholder:"请输入角色的中文名",size:"small"},model:{value:e.role.namezh,callback:function(t){e.$set(e.role,"namezh",t)},expression:"role.namezh"}}),a("el-button",{attrs:{size:"small",icon:"el-icon-plus",type:"primary"},on:{click:e.addRole}},[e._v("添加角色")])],1),a("div",[a("el-collapse",{staticStyle:{width:"35%"},attrs:{accordion:""},on:{change:e.change},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},e._l(e.roles,(function(t,n){return a("el-collapse-item",{key:n+"",attrs:{title:t.namezh,name:t.id}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("可访问资源")]),a("el-button",{staticStyle:{float:"right",padding:"3px 0"},attrs:{type:"danger",icon:"el-icon-delete",size:"small"},on:{click:function(a){return e.deleteRole(t.id,t.namezh)}}})],1),a("el-tree",{key:n+"",ref:"tree",refInFor:!0,attrs:{data:e.allMenus,props:e.defaultProps,"show-checkbox":"","node-key":"id","default-checked-keys":e.selectedMenus,"default-expanded-keys":e.selectedMenus}}),a("div",{staticClass:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.activeName=-1}}},[e._v("取消修改")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(a){return e.updatePermiss(t.id,n)}}},[e._v("确定修改")])],1)],1)],1)})),1)],1)])},D=[],S={name:"PermissMana",data:function(){return{roles:[],default_value:"ROLE_",allMenus:[],defaultProps:{children:"children",label:"name"},role:{name:"",namzh:""},selectedMenus:[],activeName:-1,loading:!0}},mounted:function(){this.initRoles()},methods:{initRoles:function(){var e=this;this.getRequest("/system/basic/permiss/").then((function(t){e.loading=!1,t?e.roles=t.object:e.$message.error("加载角色信息失败！")}))},initMenus:function(){var e=this;this.getRequest("/system/basic/permiss/menus/").then((function(t){t?e.allMenus=t.object:e.$message.error("加载菜单失败！")}))},addRole:function(){var e=this;this.role.name&&this.role.namezh?this.postRequest("/system/basic/permiss/",this.role).then((function(t){t&&(e.role={name:"",namezh:""},e.initRoles())})):this.$message.error("添加框不能为空！")},change:function(e){e&&(this.initMenus(),this.initSelectedMenus(e))},initSelectedMenus:function(e){var t=this;this.getRequest("/system/basic/permiss/getMenuId/"+e).then((function(e){e?(console.log(e.object),t.selectedMenus=e.object):t.$message.error("加载角色资源失败！")}))},updatePermiss:function(e,t){var a=this,n=this.$refs.tree,i=n[t].getCheckedKeys(!0),s="/system/basic/permiss/?rid="+e+"&",l="";i.forEach((function(e){l+="mids="+e+"&"})),this.putRequest(s+l).then((function(e){e&&(a.activeName=-1)}))},deleteRole:function(e,t){var a=this;this.$confirm("此操作将永久删除【"+t+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){a.deleteRequest("/system/basic/permiss/"+e).then((function(e){e&&a.initRoles()}))})).catch((function(){a.$message({type:"info",message:"已取消删除"})}))}}},$=S,z=(a("778d"),Object(c["a"])($,R,D,!1,null,"94e80140",null)),j=z.exports,C=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[a("div",[a("el-input",{staticStyle:{width:"375px"},attrs:{size:"small",placeholder:"添加职位","prefix-icon":"el-icon-plus"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addPosition(t)}},model:{value:e.pos.name,callback:function(t){e.$set(e.pos,"name",t)},expression:"pos.name"}}),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{size:"small",icon:"el-icon-plus",type:"primary"},on:{click:e.addPosition}},[e._v("添加职位")]),a("el-table",{staticStyle:{width:"50%","margin-top":"30px"},attrs:{data:e.posData,border:"",stripe:""},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"80"}}),a("el-table-column",{attrs:{prop:"name",label:"职位名称",width:"200"}}),a("el-table-column",{attrs:{prop:"createdate",label:"创建时间"}}),a("el-table-column",{attrs:{label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.enabled?a("el-tag",{staticClass:"enabled",attrs:{type:"success"},on:{click:function(a){return e.changeEnable(t.row)}}},[e._v("已启用")]):a("el-tag",{staticClass:"enabled",attrs:{type:"danger"},on:{click:function(a){return e.changeEnable(t.row)}}},[e._v("已禁止")])]}}])}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.deletePosition(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1),a("div",[a("el-dialog",{staticClass:"dialog",attrs:{title:"编辑职位名称",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",[a("el-tag",{attrs:{effect:"dark"}},[e._v("职位名称")]),a("el-input",{staticStyle:{width:"40%","margin-left":"10px"},attrs:{size:"small",placeholder:"请输入内容"},model:{value:e.updateData.name,callback:function(t){e.$set(e.updateData,"name",t)},expression:"updateData.name"}})],1),a("div",[a("el-tag",{attrs:{effect:"dark"}},[e._v("是否启用")]),a("el-switch",{staticStyle:{"margin-left":"10px"},attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":e.updateData.text()},model:{value:e.updateData.enabled,callback:function(t){e.$set(e.updateData,"enabled",t)},expression:"updateData.enabled"}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.updataPosition}},[e._v("确 定")])],1)])],1),a("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0===this.multipleSelection.length},on:{click:e.deletePositionsByIds}},[e._v("批量删除")])],1)},E=[],q=(a("b53c"),{name:"PosMana",data:function(){return{pos:{name:""},posData:[],dialogVisible:!1,updateData:{name:"",enabled:!1,text:function(){return this.enabled?"已启用":"已禁止"}},multipleSelection:[],loading:!0}},mounted:function(){this.initPositions()},methods:{initPositions:function(){var e=this;this.getRequest("/system/basic/pos/").then((function(t){e.loading=!1,t&&(e.posData=t.object,e.pos.name="")}))},addPosition:function(){var e=this;this.pos.name?this.postRequest("/system/basic/pos/",this.pos).then((function(t){t&&e.initPositions()})):this.$message.error("需要添加的职位名不能为空")},deletePosition:function(e,t){var a=this;this.$confirm("此操作将永久删除【"+t.name+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){a.deleteRequest("/system/basic/pos/"+t.id).then((function(e){e&&a.initPositions()}))})).catch((function(){a.$message({type:"info",message:"已取消删除"})}))},deletePositionsByIds:function(){var e=this;this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"条数据】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t="?";e.multipleSelection.forEach((function(e){t+="ids="+e.id+"&"})),e.deleteRequest("/system/basic/pos/multi/"+t).then((function(t){t&&e.initPositions()}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},updataPosition:function(){var e=this;this.putRequest("/system/basic/pos/",this.updateData).then((function(t){t&&(e.initPositions(),e.dialogVisible=!1)}))},handleEdit:function(e,t){this.dialogVisible=!0,Object.assign(this.updateData,t)},handleSelectionChange:function(e){this.multipleSelection=e,console.log(e)},changeEnable:function(e){var t=this,a={id:e.id,name:e.name,enabled:!e.enabled};e&&this.putRequest("/system/basic/pos/",a).then((function(e){e&&t.initPositions()}))}}}),J=q,L=(a("a8b8"),Object(c["a"])(J,C,E,!1,null,"2106d158",null)),P=L.exports,B={name:"SysBasic",data:function(){return{activeName:"depname"}},components:{"dep-mana":u,"ec-mana":v,"job-level-mana":w,"permiss-mana":j,"pos-mana":P}},N=B,O=Object(c["a"])(N,n,i,!1,null,"2843d0f6",null);t["default"]=O.exports},"95be":function(e,t,a){},a8b8:function(e,t,a){"use strict";var n=a("6644"),i=a.n(n);i.a},d1e3:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 备份恢复数据库 ")])},i=[],s={name:"SysData"},l=s,o=a("2877"),r=Object(o["a"])(l,n,i,!1,null,"378fd116",null);t["default"]=r.exports},e689:function(e,t,a){}}]);
//# sourceMappingURL=chunk-ce79652a.4af70fb4.js.map