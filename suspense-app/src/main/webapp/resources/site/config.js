var config = {};

config.api = [ 
    {
		module : "用户相关",
		payload : [ 
			{
				name : "用户注册",
				id : "register",
				path : "busiUser/register",
				path2 : "busiUser/register",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					bsusrPwd : '1234567',
					confirmPwd : '1234567',
					bsaqnQuestion : '10001',
					bsaqnResult : '123',
					version : 'V1.0.0'
				}
			},
			{
				name : "用户登录",
				id : "login",
				path : "busiUser/login",
				path2 : "busiUser/login",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					bsusrPwd : '1234567',
					version : 'V1.0.0'
				}
			},
			{
				name : "忘记密码",
				id : "forgetPwd",
				path : "busiUser/forget/pwd",
				path2 : "busiUser/forget/pwd",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					newPwd : '1234567',
					confirmPwd : '1234567',
					bsaqnQuestion : '10001',
					bsaqnResult : '123'
				}
			},
			{
				name : "修改密码",
				id : "updatePwd",
				path : "busiUser/update/pwd",
				path2 : "busiUser/update/pwd",
				method : "post",
				params : {
					bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
					oldPwd : '1234567',
					newPwd : '1234567',
					confirmPwd : '1234567'
				}
			},
			{
				name : "用户登出",
				id : "logout",
				path : "busiUser/logout",
				path2 : "busiUser/logout",
				method : "post",
				params : {
				}
			}
		]
    },{
    	module : "密保问题",
    	payload : [
    	    {
    	        name : "获取密保问题列表",
    			id : "getAllSafeQuestions",
    			path : "busiQuestion/sel",
    			path2 : "busiQuestion/sel",
    			method : "post",
    			params : {
    			} 
    	    },
    	    {
    	        name : "更新用户的密保问题",
    			id : "updateAnswerquestion",
    			path : "busiAnswerquestion/update",
    			path2 : "busiAnswerquestion/update",
    			method : "post",
    			params : {
    				bsaqnUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsaqnQuestion : '10001',
    				bsaqnResult : '123'
    			} 
    	    },
    	    {
    	        name : "获取用户的密保问题",
    			id : "getAnswerquestion",
    			path : "busiAnswerquestion/get",
    			path2 : "busiAnswerquestion/get",
    			method : "post",
    			params : {
    				bsaqnUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    }
    	]
    },{
    	module : "个人中心",
    	payload : [
    	    {
    	        name : "添加反馈意见",
    			id : "addFeedback",
    			path : "busiFeedback/add",
    			path2 : "busiFeedback/add",
    			method : "post",
    			params : {
    				bsfbkContent : '我有意见',
    				bsfbkUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsfbkRelation : '1556377990@qq.com'
    			} 
    	    },
    	    {
    	        name : "版本更新",
    			id : "getVersion",
    			path : "busiVersion/get",
    			path2 : "busiVersion/get",
    			method : "post",
    			params : {
    				bsvsnNo : 'V0.0.1',
    				bsvsnType : 1
    			} 
    	    },
    	    {
    	        name : "更改个人信息",
    			id : "updateUesrInfo",
    			path : "busiUser/update/user/info",
    			path2 : "busiUser/update/user/info",
    			method : "post",
    			params : {
    				bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsusrCode : 'zhang',
    				bsusrSignature : '',
    				bsusrBirthday : '2014-12-08',
    				bsusrSex : 1,
    				bsusrHobby : '',
    				bsusrCity : '杭州',
    				bsusrHeadUrl : '',
    				bsusrPersonalNote : '',
    				bsusrPhone : ''
    			} 
    	    },
    	    {
    	        name : "查询个人信息",
    			id : "findUesrInfo",
    			path : "busiUser/find/user/info",
    			path2 : "busiUser/find/user/info",
    			method : "post",
    			params : {
    				bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				attentUserUuid : 'YUSFOPVLEHXBFMVKPYZSCVXQNWKCRBGP'
    			} 
    	    }
    	]
    },{
    	module : "图片处理",
    	payload : [
    	    {
    	        name : "获取头像",
    			id : "getAccountHeadPic",
    			path : "image/account/head/get/{picName}",
    			path2 : "image/account/head/get/1",
    			method : "get",
    			params : {
    			} 
    	    },
    	    {
    	        name : "获取悬疑帖子原图",
    			id : "getFunPicOriginal",
    			path : "image/suspense/get/original/{picName}",
    			path2 : "image/suspense/get/original/1",
    			method : "get",
    			params : {
    			} 
    	    },
    	    {
    	        name : "获取悬疑帖子缩略图",
    			id : "getFunPicThumbnail",
    			path : "image/suspense/get/thumbnail/{picName}",
    			path2 : "image/suspense/get/thumbnail/1",
    			method : "get",
    			params : {
    			} 
    	    }
    	]
    },{
    	module : "悬疑故事",
    	payload : [
			{
			    name : "悬疑故事列表",
				id : "findSuspenseStoryList",
				path : "busiSuspenseStory/suspense/story/list",
				path2 : "busiSuspenseStory/suspense/story/list",
				method : "post",
				params : {
					lastId : 10,
					limit : 3
				} 
			},
			{
    	        name : "悬疑故事顶",
    			id : "goodSuspenseStory",
    			path : "busiSuspenseStory/suspense/story/good",
    			path2 : "busiSuspenseStory/suspense/story/good",
    			method : "post",
    			params : {
    				bsssyUuid : 'TNYAVEGSXSDCAEGXSSJLQKANOZZUWYZC',
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "悬疑故事详情",
    			id : "findSuspenseContentDetail",
    			path : "busiSuspenseContent/suspense/content/detail",
    			path2 : "busiSuspenseContent/suspense/content/detail",
    			method : "post",
    			params : {
    				bssctOrd : 2,
    				bssctStory : 'TNYAVEGSXSDCAEGXSSJLQKANOZZUWYZC'
    			} 
    	    },
    	    {
    	        name : "添加评论",
    			id : "addComment",
    			path : "busiComment/comment/add",
    			path2 : "busiComment/comment/add",
    			method : "post",
    			params : {
    				bscotUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscotStory : 'TNYAVEGSXSDCAEGXSSJLQKANOZZUWYZC',
    				bscotContent : '啦啦啦啦啦啦啦啦'
    			} 
    	    },
    	    {
    	        name : "评论列表",
    			id : "findBusiCommentByStory",
    			path : "busiComment/comment/list",
    			path2 : "busiComment/comment/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				bscotStory : 'TNYAVEGSXSDCAEGXSSJLQKANOZZUWYZC',
    				limit : 3
    			} 
    	    }
    	]
    },{
    	module : "每日竞猜",
    	payload : [
			{
			    name : "竞猜",
				id : "addQuiz",
				path : "busiQuiz/quiz/add",
				path2 : "busiQuiz/quiz/add",
				method : "post",
				params : {
					bsqizUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
					bsqizSuspense : 'NROOBIIOSOWAXLKVCMAPKGNOYRJKENFS',
					bsqizAnswer : '我的回答1',
					bsqizScore : 1
				} 
			},
    	    {
    	        name : "每日竞猜列表/历史竞猜列表",
    			id : "findSuspenseDayList",
    			path : "busiSuspenseDay/suspense/day/list",
    			path2 : "busiSuspenseDay/suspense/day/list",
    			method : "post",
    			params : {
    				bssdyDay : '2015-01-15',
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "我的竞猜列表",
    			id : "finSuspenseDayQuizList",
    			path : "busiSuspenseDay/suspense/day/quiz/list",
    			path2 : "busiSuspenseDay/suspense/day/quiz/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "我的收藏列表",
    			id : "finSuspenseDayCollectList",
    			path : "busiSuspenseDay/suspense/day/collect/list",
    			path2 : "busiSuspenseDay/suspense/day/collect/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "收藏竞猜",
    			id : "addCollect",
    			path : "busiCollect/collect/add",
    			path2 : "busiCollect/collect/add",
    			method : "post",
    			params : {
    				bscltUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscltSuspense : 'NROOBIIOSOWAXLKVCMAPKGNOYRJKENFS'
    			} 
    	    },
    	    {
    	        name : "取消收藏",
    			id : "cancelCollect",
    			path : "busiCollect/collect/cancel",
    			path2 : "busiCollect/collect/cancel",
    			method : "post",
    			params : {
    				bscltUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscltSuspense : 'NROOBIIOSOWAXLKVCMAPKGNOYRJKENFS'
    			} 
    	    }
    	]
    },{
    	module : "悬疑社区",
    	payload : [
    	    {
    	        name : "帖子列表",
    			id : "findPostList",
    			path : "busiPost/post/list",
    			path2 : "busiPost/post/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "我的帖子",
    			id : "findMyPostList",
    			path : "busiPost/my/post/list",
    			path2 : "busiPost/my/post/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "帖子详情",
    			id : "findPostDetail",
    			path : "busiPost/post/detail",
    			path2 : "busiPost/post/detail",
    			method : "post",
    			params : {
    				bspstUuid : 'GHJHJHKJKKJLKLKLIPEWPLKXMNZDRQAS'
    			} 
    	    },
    	    {
    	        name : "帖子顶",
    			id : "goodPost",
    			path : "busiPost/post/good",
    			path2 : "busiPost/post/good",
    			method : "post",
    			params : {
    				bspstUuid : 'GHJHJHKJKKJLKLKLIPEWPLKXMNZDRQAS',
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "发帖",
    			id : "addBusiPost",
    			path : "busiPost/post/add",
    			path2 : "busiPost/post/add",
    			method : "post",
    			params : {
    				bspstUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bspstTitle : '标题1',
    				bspstContent : '内容1',
    				bspstType : 0
    			} 
    	    },
    	    {
    	        name : "跟帖",
    			id : "addFollowPost",
    			path : "busiFollowPost/follow/post/add",
    			path2 : "busiFollowPost/follow/post/add",
    			method : "post",
    			params : {
    				bsfptUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsfptPost : 'GHJHJHKJKKJLKLKLIPEWPLKXMNZDRQAS',
    				bsfptContent : '内容1'
    			} 
    	    },
    	    {
    	        name : "跟帖列表",
    			id : "findFollowPostList",
    			path : "busiFollowPost/follow/post/list",
    			path2 : "busiFollowPost/follow/post/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				postUuid : 'GHJHJHKJKKJLKLKLIPEWPLKXMNZDRQAS',
    				limit : 3
    			} 
    	    }
    	]
    },{
    	module : "小纸条",
    	payload : [
    	    {
    	        name : "我关注的人",
    			id : "findReportList",
    			path : "busiReport/report/list",
    			path2 : "busiReport/report/list",
    			method : "post",
    			params : {
    				bsrptAttention : 'AHUXVECAWDMDRDUSJWKDCFSIUTWUDAGW',
    				lastId : 10,
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "关注我的人",
    			id : "findBeReportList",
    			path : "busiReport/bereport/list",
    			path2 : "busiReport/bereport/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				bsrptBeAttention : 'AHUXVECAWDMDRDUSJWKDCFSIUTWUDAGW',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "聊天详情",
    			id : "findBusiNotechatList",
    			path : "busiNotechat/notechat/list",
    			path2 : "busiNotechat/notechat/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				reportUuid : 'DGFDGFHFGJHDGJHGJ',
    				userUuid : 'AHUXVECAWDMDRDUSJWKDCFSIUTWUDAGW',
    				limit : 10
    			} 
    	    },
    	    {
    	        name : "添加聊天内容",
    			id : "addBusiNotechat",
    			path : "busiNotechat/notechat/add",
    			path2 : "busiNotechat/notechat/add",
    			method : "post",
    			params : {
    				bsnctReport : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE',
    				bsnctContent : '我是内容1',
    				bsnctUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsnctType : 1
    				
    			} 
    	    },
    	    {
    	        name : "关注",
    			id : "addReport",
    			path : "busiReport/report/add",
    			path2 : "busiReport/report/add",
    			method : "post",
    			params : {
    				bsrptAttention : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsrptBeAttention : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "取消关注1",
    			id : "cancelReport1",
    			path : "busiReport/report/cancel",
    			path2 : "busiReport/report/cancel",
    			method : "post",
    			params : {
    				bsrptAttention : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsrptBeAttention : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "取消关注2",
    			id : "cancelReport2",
    			path : "busiReport/report/cancel/{bsrptUuid}",
    			path2 : "busiReport/report/cancel/WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE",
    			method : "post",
    			params : {
    			} 
    	    }
    	]
    }
];

var _attachId = function(api) {
	for (var i = 0; i < api.length; i++) {
		var mid = "m" + i;
		api[i].id = mid;
		var pd = api[i].payload;
		for (var j = 0; j < pd.length; j++) {
			var aid = "i" + j;
			pd[j].id = mid + aid;

		}
	}

};
_attachId(config.api);

if ( typeof module === "object" && module && typeof module.exports === "object" ) {	
	module.exports = config.api;
}