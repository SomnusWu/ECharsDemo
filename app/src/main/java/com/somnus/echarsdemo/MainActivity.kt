package com.somnus.echarsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var mWebView: EChartsWebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebView = findViewById(R.id.echarsWebView);

        val datas = "let data = [[\"21:10\", 1], [\"22:15\", 1], [\"23:10\", 1], [\"1:10\", 1], [\"3:10\", 1]]\n" +
                "      let data1 = [[\"21:10\", 2], [\"22:15\", 2], [\"23:10\", 2], [\"1:10\", 2], [\"3:10\", 2]]\n" +
                "      let time = data.map(item => {\n" +
                "        return item[0]\n" +
                "      })\n" +
                "      time.push(...[\"4:10\", \"5:10\", \"6:10\", \"7:10\"])\n" +
                "option = {\n" +
                "        tooltip: {\n" +
                "          trigger: 'axis'\n" +
                "        },\n" +
                "        legend: {\n" +
                "          left: 40,\n" +
                "          top: 20,\n" +
                "          data: ['宫颈扩张(cm)', '胎先露下降程度(cm)',],\n" +
                "        },\n" +
                "        grid: {\n" +
                "          left: '60',\n" +
                "          right: '40',\n" +
                "          bottom: '10',\n" +
                "          containLabel: true\n" +
                "        },\n" +
                "        xAxis: [\n" +
                "          {\n" +
                "            data: time,\n" +
                "            position: 'bottom',// 很重要，如果没有这个设置，默认第二个x轴就会在图表的顶部\n" +
                "            offset: 0,// X 轴相对于默认位置的偏移，在相同的 position 上有多个 X 轴的时候有用\n" +
                "            type: \"category\",// 坐标轴类型\n" +
                "            boundaryGap: false,\n" +
                "            axisTick: { show: false },// 是否显示坐标轴刻度\n" +
                "            axisLine: { show: false },// 是否显示坐标轴轴线\n" +
                "          },\n" +
                "        ],\n" +
                "        yAxis: [{\n" +
                "          offset: 0,\n" +
                "          name: '宫\\n颈\\n扩\\n张\\ncm',\n" +
                "          nameLocation: 'left',\n" +
                "          nameTextStyle: {\n" +
                "            lineHeight: 20,\n" +
                "            color: \"#087cff\",\n" +
                "            fontSize: 14,\n" +
                "            padding: [0, 90, -50, 0]\n" +
                "          },\n" +
                "          nameGap: 20,\n" +
                "          type: 'value',\n" +
                "          alignTicks: true,\n" +
                "          interval: 1,\n" +
                "          min: 0,\n" +
                "          max: 10,\n" +
                "          splitLine: {\n" +
                "            lineStyle: {\n" +
                "              // 设置背景横线\n" +
                "              color: 'red'\n" +
                "            }\n" +
                "          },\n" +
                "        },\n" +
                "        {\n" +
                "          name: '胎\\n先\\n露\\n下\\n降\\n程\\n度\\ncm',\n" +
                "          // nameLocation: 'end',\n" +
                "          nameLocation: 'right',\n" +
                "          nameTextStyle: {\n" +
                "            lineHeight: 20,\n" +
                "            color: \"#087cff\",\n" +
                "            fontSize: 14,\n" +
                "            padding: [0, 0, -80, 90]\n" +
                "          },\n" +
                "          alignTicks: true,\n" +
                "          type: 'value',\n" +
                "          interval: 1,\n" +
                "          min: -5,\n" +
                "          max: 5,\n" +
                "          z: 2,\n" +
                "          splitLine: {\n" +
                "            z: 2,\n" +
                "            lineStyle: {\n" +
                "              // 设置背景横线\n" +
                "              width: 1,\n" +
                "              color: '#ffffff',\n" +
                "            }\n" +
                "          },\n" +
                "        }\n" +
                "        ],\n" +
                "        series: [\n" +
                "          {\n" +
                "            name: \"宫颈扩张(cm)\",\n" +
                "            type: 'line',\n" +
                "            data: data,\n" +
                "            z: 3,\n" +
                "            markLine: {\n" +
                "              z: 1,\n" +
                "              symbol: ['none', 'none'],\n" +
                "              data: [\n" +
                "                { xAxis: \"23:10\", lineStyle: { color: \"rgba(0,0,0,0)\" }, label: { formatter: \"3M\", show: true, position: \"end\" } },\n" +
                "                { yAxis: 5, lineStyle: { color: '#ce0900', width: 1, type: 'solid' }, label: { formatter: \"\", show: true, position: \"end\" } },\n" +
                "                { xAxis: \"1:10\", lineStyle: { color: \"rgba(0,0,0,0)\", width: 1, type: 'solid' }, label: { formatter: \"5M\", show: true, position: \"end\" } },\n" +
                "                [\n" +
                "                  {\n" +
                "                    xAxis: \"1:10\",\n" +
                "                    yAxis: 3,\n" +
                "                    lineStyle: { color: \"rgba(0,0,0,1)\", width: 1, type: 'dashed' },\n" +
                "                    label: { formatter: \"警戒线\", show: true, position: \"end\" }\n" +
                "                  },\n" +
                "                  {\n" +
                "                    xAxis: \"4:10\",\n" +
                "                    yAxis: 10,\n" +
                "                  }\n" +
                "                ],\n" +
                "                [\n" +
                "                  {\n" +
                "                    xAxis: \"4:10\",\n" +
                "                    yAxis: 3,\n" +
                "                    lineStyle: { color: \"rgba(0,0,0,1)\", width: 1, type: 'dashed' },\n" +
                "                    label: { formatter: \"异常线\", show: true, position: \"end\" }\n" +
                "                  },\n" +
                "                  {\n" +
                "                    xAxis: \"6:10\",\n" +
                "                    yAxis: 10,\n" +
                "                  }\n" +
                "                ]\n" +
                "              ],\n" +
                "              lineStyle: {\n" +
                "                z: 10,\n" +
                "                width: 2\n" +
                "              }\n" +
                "            },\n" +
                "            markArea: {\n" +
                "              z: 100,\n" +
                "              silent: true,\n" +
                "              data: [\n" +
                "                [\n" +
                "                  {\n" +
                "                    name: '潜伏期',\n" +
                "                    label: {\n" +
                "                      offset: [0, -10],\n" +
                "                      z: 100,\n" +
                "                      position: 'inside',\n" +
                "                      color: '#7db3fd'\n" +
                "                    },\n" +
                "                    z: 100,\n" +
                "                    itemStyle: {\n" +
                "                      z: 100,\n" +
                "                      opacity: 1,\n" +
                "                      color: '#d0e4ff'\n" +
                "                    },\n" +
                "                    xAxis: \"21:10\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                    xAxis: \"23:10\"\n" +
                "                  }\n" +
                "                ],\n" +
                "                [\n" +
                "                  {\n" +
                "\n" +
                "                    label: {\n" +
                "                      offset: [0, -10],\n" +
                "                      position: 'inside',\n" +
                "                      color: '#1d84fe',\n" +
                "                      z: 100,\n" +
                "                    },\n" +
                "                    name: '活跃期',\n" +
                "                    xAxis: '23:10',\n" +
                "                    z: 100,\n" +
                "                    itemStyle: {\n" +
                "                      z: 100,\n" +
                "                      opacity: 1,\n" +
                "                      color: '#99c2fd'\n" +
                "                    },\n" +
                "                  },\n" +
                "                  {\n" +
                "                    xAxis: '1:10'\n" +
                "                  }\n" +
                "                ],\n" +
                "                [\n" +
                "                  {\n" +
                "                    label: {\n" +
                "                      offset: [0, -10],\n" +
                "                      position: 'inside',\n" +
                "                      color: '#c07e12',\n" +
                "                      lineHeight: 20,\n" +
                "                      z: 100,\n" +
                "                    },\n" +
                "                    name: '第\\n二\\n产\\n程',\n" +
                "                    xAxis: '1:10',\n" +
                "                    z: 100,\n" +
                "                    itemStyle: {\n" +
                "                      z: 100,\n" +
                "                      opacity: 1,\n" +
                "                      color: '#ffd499'\n" +
                "                    },\n" +
                "                  },\n" +
                "                  {\n" +
                "                    xAxis: '3:10'\n" +
                "                  }\n" +
                "                ]\n" +
                "              ]\n" +
                "            },\n" +
                "            lineStyle: {\n" +
                "              width: 2,\n" +
                "              color: \"#2ad444\"\n" +
                "            },\n" +
                "            itemStyle: {\n" +
                "              normal: {\n" +
                "                color: '#2ad444'\n" +
                "              }\n" +
                "            }\n" +
                "          },\n" +
                "          {\n" +
                "            yAxisIndex: 1,\n" +
                "            name: '胎先露下降程度(cm)',\n" +
                "            type: 'line',\n" +
                "            // stack: 'Total',                      \n" +
                "            data: data1,\n" +
                "            lineStyle: {\n" +
                "              width: 2,\n" +
                "              color: \"#166ce2\"\n" +
                "            },\n" +
                "            itemStyle: {\n" +
                "              normal: {\n" +
                "                color: '#166ce2'\n" +
                "              }\n" +
                "            }\n" +
                "          },       \n" +
                "        ]\n" +
                "      }"
//        mWebView.setData(getString(R.string.chats_string))
//        mWebView.setData(datas)
//        mWebView.setData("{\n" +
//                "  title: {\n" +
//                "    text: 'Stacked Area Chart'\n" +
//                "  },\n" +
//                "  tooltip: {\n" +
//                "    trigger: 'axis',\n" +
//                "    axisPointer: {\n" +
//                "      type: 'cross',\n" +
//                "      label: {\n" +
//                "        backgroundColor: '#6a7985'\n" +
//                "      }\n" +
//                "    }\n" +
//                "  },\n" +
//                "  legend: {\n" +
//                "    data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']\n" +
//                "  },\n" +
//                "  toolbox: {\n" +
//                "    feature: {\n" +
//                "      saveAsImage: {}\n" +
//                "    }\n" +
//                "  },\n" +
//                "  grid: {\n" +
//                "    left: '3%',\n" +
//                "    right: '4%',\n" +
//                "    bottom: '3%',\n" +
//                "    containLabel: true\n" +
//                "  },\n" +
//                "  xAxis: [\n" +
//                "    {\n" +
//                "      type: 'category',\n" +
//                "      boundaryGap: false,\n" +
//                "      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  yAxis: [\n" +
//                "    {\n" +
//                "      type: 'value'\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  series: [\n" +
//                "    {\n" +
//                "      name: 'Email',\n" +
//                "      type: 'line',\n" +
//                "      stack: 'Total',\n" +
//                "      areaStyle: {},\n" +
//                "      emphasis: {\n" +
//                "        focus: 'series'\n" +
//                "      },\n" +
//                "      data: [120, 132, 101, 134, 90, 230, 210]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      name: 'Union Ads',\n" +
//                "      type: 'line',\n" +
//                "      stack: 'Total',\n" +
//                "      areaStyle: {},\n" +
//                "      emphasis: {\n" +
//                "        focus: 'series'\n" +
//                "      },\n" +
//                "      data: [220, 182, 191, 234, 290, 330, 310]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      name: 'Video Ads',\n" +
//                "      type: 'line',\n" +
//                "      stack: 'Total',\n" +
//                "      areaStyle: {},\n" +
//                "      emphasis: {\n" +
//                "        focus: 'series'\n" +
//                "      },\n" +
//                "      data: [150, 232, 201, 154, 190, 330, 410]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      name: 'Direct',\n" +
//                "      type: 'line',\n" +
//                "      stack: 'Total',\n" +
//                "      areaStyle: {},\n" +
//                "      emphasis: {\n" +
//                "        focus: 'series'\n" +
//                "      },\n" +
//                "      data: [320, 332, 301, 334, 390, 330, 320]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      name: 'Search Engine',\n" +
//                "      type: 'line',\n" +
//                "      stack: 'Total',\n" +
//                "      label: {\n" +
//                "        show: true,\n" +
//                "        position: 'top'\n" +
//                "      },\n" +
//                "      areaStyle: {},\n" +
//                "      emphasis: {\n" +
//                "        focus: 'series'\n" +
//                "      },\n" +
//                "      data: [820, 932, 901, 934, 1290, 1330, 1320]\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}")
//        mWebView.setData("{" +"}");

//        [["21:10", 1], ["22:15", 1], ["23:10", 1], ["1:10", 1], ["3:10", 1]]

        val mList = mutableListOf<Any>()
        val mChildArr1 = mutableListOf<Any>()
        mChildArr1.add("21:10")
        mChildArr1.add(1)
        mList.add(mChildArr1)

        mWebView.setData("{" +"}",mList);
//        mWebView.setEmpty()
    }
}