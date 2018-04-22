
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>

<body>

<div id='main' style='width:600px;height:400px;'></div>
<div id='main1' style='width:800px;height:600px;'></div>
<div id='main2' style='width:1800px;height:1600px;'></div>
<!--引入echarts.js-->
<script src='./echarts.min.js'></script>
<script src='./china.js'></script>
<script>
    //基于准备好的DOM，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart2 = echarts.init(document.getElementById('main2'));
    var option = {
        title:{
            text:'EChars入门'
        },
        //提示框组件
        tooltip:{
            //坐标轴触发，主要用于柱状图，折线图等
            trigger:'axis'
        },
        //图例
        legend:{
            data:['销量','销']
        },
        //横轴
        xAxis:{
            data:["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        //纵轴
        yAxis:{},
        //系列列表。每个系列通过type决定自己的图表类型
        series:[{
            name:'销量',
            //折线图
            type:'line',
            data:[5, 20, 36, 10, 10, 20]
        },{
            name:'销',
            //折线图
            type:'line',
            data:[5, 20, 255, 10, 0, 20]
        }]
    };
    //使用刚指定的配置项和数据显示图表
    myChart.setOption(option);

    var myChart1 = echarts.init(document.getElementById('main1'));

   var option1 = {
        backgroundColor: "#404A59",
        color: ['#ffd285', '#ff733f', '#ec4863'],

        title: [{
            text: '城市宝周新增用户报表',
            left: '1%',
            top: '6%',
            textStyle: {
                color: '#fff'
            }
        }, {
            text: '用户来源占比',
            left: '83%',
            top: '6%',
            textAlign: 'center',
            textStyle: {
                color: '#fff'
            }
        }],
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            x: 300,
            top: '7%',
            textStyle: {
                color: '#ffd285',
            },
            data: ['在大理', '标准版', '潍V']
        },
        grid: {
            left: '1%',
            right: '35%',
            top: '16%',
            bottom: '6%',
            containLabel: true
        },
        toolbox: {
            "show": false,
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            "axisLine": {
                lineStyle: {
                    color: '#FF4500'
                }
            },
            "axisTick": {
                "show": false
            },
            axisLabel: {
                textStyle: {
                    color: '#fff'
                }
            },
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            "axisLine": {
                lineStyle: {
                    color: '#fff'
                }
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#fff'
                }
            },
            "axisTick": {
                "show": false
            },
            axisLabel: {
                textStyle: {
                    color: '#fff'
                }
            },
            type: 'value'
        },
        series: [{
            name: '在大理',
            smooth: true,
            type: 'line',
            symbolSize: 8,
            symbol: 'circle',
            data: [90, 50, 39, 50, 120, 82, 80]
        }, {
            name: '标准版',
            smooth: true,
            type: 'line',
            symbolSize: 8,
            symbol: 'circle',
            data: [70, 50, 50, 87, 90, 80, 70]
        }, {
            name: '潍V',
            smooth: true,
            type: 'line',
            symbolSize: 8,
            symbol: 'circle',
            data: [290, 200,20, 132, 15, 200, 90]
        },
            {
                type: 'pie',
                center: ['83%', '33%'],
                radius: ['25%', '30%'],
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: 335,
                    name: '用户来源分析',
                    itemStyle: {
                        normal: {
                            color: '#ffd285'
                        }
                    },
                    label: {
                        normal: {
                            formatter: '{d} %',
                            textStyle: {
                                color: '#ffd285',
                                fontSize: 20

                            }
                        }
                    }
                }, {
                    value: 180,
                    name: '占位',
                    tooltip: {
                        show: false
                    },
                    itemStyle: {
                        normal: {
                            color: '#87CEFA'
                        }
                    },
                    label: {
                        normal: {
                            textStyle: {
                                color: '#ffd285',
                            },
                            formatter: '\n手机号注册'
                        }
                    }
                }]
            },


            {
                type: 'pie',
                center: ['83%', '72%'],
                radius: ['25%', '30%'],
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: 435,
                    name: '用户来源分析',
                    itemStyle: {
                        normal: {
                            color: '#ff733f'
                        }
                    },
                    label: {
                        normal: {
                            formatter: '{d} %',
                            textStyle: {
                                color: '#ff733f',
                                fontSize: 20

                            }
                        }
                    }
                }, {
                    value: 100,
                    name: '占位',
                    tooltip: {
                        show: false
                    },
                    itemStyle: {
                        normal: {
                            color: '#87CEFA'


                        }
                    },
                    label: {
                        normal: {
                            textStyle: {
                                color: '#FF4500',
                            },
                            formatter: '\n三方快捷登陆'
                        }
                    }
                }]
            }]
    }

    myChart1.setOption(option1);




    function randomData() {
        return Math.round(Math.random() * 1000);
    }

    option2 = {
        title: {
            text: 'iphone销量',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['iphone3', 'iphone4', 'iphone5']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'], // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {
                    readOnly: false
                },
                restore: {},
                saveAsImage: {}
            }
        },
        series: [{
            name: 'iphone3',
            type: 'map',
            mapType: 'china',
            roam: false,
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            data: [{
                name: '北京',
                value: randomData()
            }, {
                name: '天津',
                value: randomData()
            }, {
                name: '上海',
                value: randomData()
            }, {
                name: '重庆',
                value: randomData()
            }, {
                name: '河北',
                value: randomData()
            }, {
                name: '河南',
                value: randomData()
            }, {
                name: '云南',
                value: randomData()
            }, {
                name: '辽宁',
                value: randomData()
            }, {
                name: '黑龙江',
                value: randomData()
            }, {
                name: '湖南',
                value: randomData()
            }, {
                name: '安徽',
                value: randomData()
            }, {
                name: '山东',
                value: randomData()
            }, {
                name: '新疆',
                value: randomData()
            }, {
                name: '江苏',
                value: randomData()
            }, {
                name: '浙江',
                value: randomData()
            }, {
                name: '江西',
                value: randomData()
            }, {
                name: '湖北',
                value: randomData()
            }, {
                name: '广西',
                value: randomData()
            }, {
                name: '甘肃',
                value: randomData()
            }, {
                name: '山西',
                value: randomData()
            }, {
                name: '内蒙古',
                value: randomData()
            }, {
                name: '陕西',
                value: randomData()
            }, {
                name: '吉林',
                value: randomData()
            }, {
                name: '福建',
                value: randomData()
            }, {
                name: '贵州',
                value: randomData()
            }, {
                name: '广东',
                value: randomData()
            }, {
                name: '青海',
                value: randomData()
            }, {
                name: '西藏',
                value: randomData()
            }, {
                name: '四川',
                value: randomData()
            }, {
                name: '宁夏',
                value: randomData()
            }, {
                name: '海南',
                value: randomData()
            }, {
                name: '台湾',
                value: randomData()
            }, {
                name: '香港',
                value: randomData()
            }, {
                name: '澳门',
                value: randomData()
            }]
        }, {
            name: 'iphone4',
            type: 'map',
            mapType: 'china',
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            data: [{
                name: '北京',
                value: randomData()
            }, {
                name: '天津',
                value: randomData()
            }, {
                name: '上海',
                value: randomData()
            }, {
                name: '重庆',
                value: randomData()
            }, {
                name: '河北',
                value: randomData()
            }, {
                name: '安徽',
                value: randomData()
            }, {
                name: '新疆',
                value: randomData()
            }, {
                name: '浙江',
                value: randomData()
            }, {
                name: '江西',
                value: randomData()
            }, {
                name: '山西',
                value: randomData()
            }, {
                name: '内蒙古',
                value: randomData()
            }, {
                name: '吉林',
                value: randomData()
            }, {
                name: '福建',
                value: randomData()
            }, {
                name: '广东',
                value: randomData()
            }, {
                name: '西藏',
                value: randomData()
            }, {
                name: '四川',
                value: randomData()
            }, {
                name: '宁夏',
                value: randomData()
            }, {
                name: '香港',
                value: randomData()
            }, {
                name: '澳门',
                value: randomData()
            }]
        }, {
            name: 'iphone5',
            type: 'map',
            mapType: 'china',
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            data: [{
                name: '北京',
                value: randomData()
            }, {
                name: '天津',
                value: randomData()
            }, {
                name: '上海',
                value: randomData()
            }, {
                name: '广东',
                value: randomData()
            }, {
                name: '台湾',
                value: randomData()
            }, {
                name: '香港',
                value: randomData()
            }, {
                name: '澳门',
                value: randomData()
            }]
        }]
    };

    myChart2.setOption(option2);
</script>

<a href="test/findUser"> azczxca</a>zczc



</body>


</html>
