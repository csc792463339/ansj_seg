package org.ansj.app.summary;

import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.util.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TagContentTest {

	@Test
	public void test() {

		String query = "信息公开 工作要点";

		String content = "国务院办公厅关于印发\n" + "2015年政府信息公开工作要点的通知\n" + "国办发〔2015〕22号\n" + "\n" + "各省、自治区、直辖市人民政府，国务院各部委、各直属机构：\n" + "　　《2015年政府信息公开工作要点》已经国务院同意，现印发给你们，请结合实际认真贯彻落实。\n"
				+ "\n" + "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　国务院办公厅\n" + "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　2015年4月3日\n" + "\n" + "　　（此件公开发布）\n" + "\n" + " \n" + "\n" + "2015年政府信息公开工作要点\n"
				+ "\n"
				+ "　　2015年是全面深化改革的关键之年，是全面推进依法治国的开局之年。做好今年政府信息公开工作的总体要求是：深入贯彻党的十八大和十八届二中、三中、四中全会精神，认真落实《中华人民共和国政府信息公开条例》（以下简称《条例》），紧紧围绕党和政府中心工作以及公众关切，推进重点领域信息公开，加强信息发布、解读和回应工作，强化制度机制和平台建设，不断增强政府信息公开实效，进一步提高政府公信力，使政府信息公开工作更好地服务于经济社会发展，促进法治政府、创新政府、廉洁政府和服务型政府建设。\n"
				+ "　　一、推进重点领域信息公开\n" + "　　继续做好安全生产、就业、财政审计、科技管理和项目经费、价格和收费、信用等领域信息公开，进一步扩大公开范围，细化公开内容。同时，推进以下领域信息公开工作：\n"
				+ "　　（一）推进行政权力清单公开。进一步推进国务院部门行政审批项目取消、下放以及非行政许可审批事项清理等信息的公开。推行地方各级政府工作部门权力清单制度，依法向社会公开政府部门的行政职权及其法律依据、实施主体、运行流程、监督方式等信息。对于承担的行政审批事项，均要发布服务指南，列明设定依据、申请条件、申请材料、基本流程、审批时限、收费依据及标准、审批决定证件、年检要求、注意事项等内容。除涉及国家秘密、商业秘密或个人隐私外，所有行政审批事项的受理、进展情况、结果等信息均应公开。（国务院审改办牵头落实）\n"
				+ "　　（二）推进财政资金信息公开。及时公开经批准的预算、预算调整、决算、预算执行情况报告及报表，并对财政转移支付安排、执行情况以及举借债务情况等重要事项作出说明。做好中央和地方部门预决算公开，积极推进预算绩效信息和国有资产占用情况公开。细化预决算公开内容，各级政府及部门预决算在公开到支出功能分类项级科目的基础上，一般公共预算基本支出逐步公开到经济分类款级科目，对下专项转移支付预决算公开到具体项目，并公开分地区的税收返还、一般性转移支付和专项转移支付情况。“三公”经费决算公开应细化说明因公出国（境）团组数及人数，公务用车购置数及保有量，国内公务接待的批次、人数，以及“三公”经费增减变化原因等信息。及时完整公开政府采购项目信息、采购文件、中标或成交结果、采购合同、投诉处理结果等。按照地方政府债券发行有关规定，及时准确披露相关信息。（财政部牵头落实）\n"
				+ "　　（三）推进公共资源配置信息公开。一是做好城镇保障性安居工程特别是棚户区改造建设项目信息、保障性住房分配信息公开工作。定期公开住房公积金管理运行情况，及时公开推进工程质量治理行动的进展情况。（住房城乡建设部牵头落实）二是做好土地供应计划、出让公告、成交公示和供应结果公开工作，重点公开棚户区改造用地年度供应计划、供地时序、宗地规划条件和土地使用要求。推进全国范围的征地信息公开平台建设，及时公开征地政策和征地信息。（国土资源部牵头落实）三是全面做好国有土地上房屋征收决定、补助奖励政策和标准、初步评估结果、补偿方案、补偿标准、补偿结果等公开工作。（住房城乡建设部牵头落实）\n"
				+ "　　（四）推进重大建设项目信息公开。重点围绕铁路、城市基础设施、节能环保、农林水、土地整治等涉及公共利益和民生领域的政府投资项目，推进审批、核准、备案等项目信息的公开，做好项目基本信息和招投标、重大设计变更、施工管理、合同履约、质量安全检查、资金管理、验收等项目实施信息的公开工作。（国务院相关部门分别落实）\n"
				+ "　　（五）推进公共服务信息公开。一是做好社会保险信息公开。定期向社会公开各项社会保险参保情况、待遇支付情况和水平，社会保险基金收支、结余和收益情况等信息。及时发布基本医疗保险、工伤保险和生育保险药品目录，以及基本医疗保险、工伤保险诊疗项目范围、辅助器具目录等信息。（人力资源社会保障部、卫生计生委分别落实）二是推进社会救助信息公开。重点做好城乡低保、特困人员供养、医疗救助、临时救助等信息公开工作；实行救助实施过程公开，加大救助对象人数、救助标准、补助水平和资金支出等信息公开力度。（民政部牵头落实）三是推进教育领域信息公开。全面实施高校招生“阳光工程”，推动高校重点做好录取程序、咨询及申诉渠道、重大事件违规处理结果、录取新生复查结果等信息公开工作，及时公开高校自主招生办法、考核程序和录取结果，全面实行考试加分考生资格公示工作。推动高校制定财务公开制度，加大高校财务公开力度。（教育部牵头落实）四是深化医疗卫生领域信息公开。做好法定传染病和重大突发公共卫生事件的信息公开，推动各类医疗机构健全信息公开目录，全面公开医疗服务、价格、收费等信息。（卫生计生委牵头落实）\n"
				+ "　　（六）推进国有企业信息公开。做好国有企业主要财务指标、整体运行情况、业绩考核结果等信息公开工作，加大国有资产保值增值、改革重组、负责人职务变动及招聘等信息公开力度。参照有关监督机构及上市公司监事会信息披露的做法，公开监事会对中央企业监督检查情况。研究制定国有企业财务信息公开指导意见，明确公开范围、内容、程序、工作要求等，进一步推动国有企业公开财务信息，推动各级履行出资人职责机构公开国有企业财务汇总信息。研究制定推进中央企业信息公开工作指导意见。（国资委牵头落实）\n"
				+ "　　（七）推进环境保护信息公开。进一步推进空气质量、水环境质量、污染物排放、污染源、建设项目环评等信息公开，做好环境重点监管对象名录和区域环境质量状况公开工作。加大环境执法检查依据、内容、标准、程序和结果公开力度。公开群众举报投诉重点环境问题处理情况，违法违规单位及其法定代表人名单和处理、整改情况。加强突发环境事件信息公开，及时公布应对情况及调查结果。推进核与辐射安全信息公开，重点公开核电厂核与辐射安全审批信息和辐射环境质量信息。（环境保护部牵头落实）\n"
				+ "　　（八）推进食品药品安全信息公开。做好食品药品重大监管政策信息、产生重大影响的食品药品典型案件，以及食品安全监督抽检、药品监督抽验信息公开工作。及时发布网上非法售药整治等专项行动信息和保健食品消费警示信息。（食品药品监管总局牵头落实）\n"
				+ "　　（九）推进社会组织、中介机构信息公开。加大社会组织成立、变更、注销、评估、年检结果、查处结果等信息公开力度。制定社会团体和民办非企业单位信息公开管理办法，推动服务、收费等事项公开。建立行政审批前置服务项目信息公开制度，公开提供服务的社会组织和中介机构名称、经营地址、资质状况等基本信息，以及实行政府定价或政府指导价的收费标准，方便企业和公众选择。推动慈善组织信息公开。（民政部、国务院其他有关部门分别落实）\n"
				+ "　　二、全面加强主动公开工作\n"
				+ "　　（一）进一步拓展主动公开内容。对于行政决策、执行、管理、服务、结果方面的信息，坚持以公开为常态、不公开为例外原则，依法依规做好公开工作。要对本地区本部门政府信息进行梳理，进一步细化主动公开范围和公开目录，并动态更新。对制作形成或在履行职责中获取的政府信息，严格落实公开属性源头认定机制，依法依规明确公开属性，确定为依申请公开或不予公开的，应当说明理由。涉及公民、法人或其他组织权利和义务的规范性文件，都要按《条例》规定全面、准确、及时做好公开工作。积极稳妥推进政府数据公开，鼓励和推动企业、第三方机构、个人等对公共数据进行深入分析和应用。\n"
				+ "　　（二）加大政策解读回应力度。对涉及面广、社会关注度高或专业性较强的重要政策法规，要同步制定解读方案，加强议题设置，通过发布权威解读稿件、组织专家撰写解读文章等多种方式，及时做好科学解读，有效开展舆论引导。适应网络传播特点，更多运用图片、图表、图解、视频等可视化方式，增强政策解读效果。健全政务舆情收集、研判和回应机制，对涉及本地区本部门的重要政务舆情、重大突发事件等热点问题，要依法按程序第一时间通过网上发布信息、召开新闻发布会、接受媒体采访等方式予以回应，并根据工作进展持续发布动态信息。回应力求表达准确、亲切、自然，为群众提供客观、可感、可信的信息，发挥正面引导作用。\n"
				+ "　　（三）发挥各类信息公开平台和渠道作用。统筹运用新闻发言人、政府网站、政府公报、政务微博微信发布信息，充分发挥广播电视、报刊、新闻网站、商业网站和政务服务中心的作用，扩大发布信息的受众面、提高影响力。特别要适应传播对象化分众化趋势以及新兴媒体平等交流、互动传播的特点，更好地运用新技术、新手段，注重用户体验和信息需求，扩大政府信息传播范围，提高信息到达率。加强不同平台和渠道发布信息的衔接协调，确保公开内容准确、一致。\n"
				+ "　　三、强化依申请公开管理和服务\n"
				+ "　　建立健全政府信息公开申请接收、登记、办理、审核、答复、归档等环节的制度规范。进一步拓展依申请公开受理渠道，更好地发挥互联网和各级政务服务中心的作用，为申请人提供便捷服务。强化政府信息公开场所的管理和服务，明确工作标准，做好现场解疑释惑工作。严格按照法定时限履行答复程序，制定统一规范的答复格式，推行申请答复文书的标准化文本，依法依规做好答复工作。探索建立依申请公开促进依法行政的机制，及时总结依申请公开工作中发现的依法行政方面的问题，加强跟踪调研，提出工作建议。及时梳理本单位本系统信息公开申请情况，按照申请内容、答复情况等进行分类管理，加强研究分析，促进工作水平不断提升。\n"
				+ "　　四、建立健全制度机制\n"
				+ "　　完善政府信息公开指南，各级行政机关年内要对本行政机关的公开指南进行复查，内容缺失或者更新不及时的，及时完善相关内容。做好信息公开统计工作，加强统计数据分析和运用。加强信息公开年度报告编制和发布工作，在《条例》规定基础上，进一步充实重点领域信息公开、政策解读回应、依申请公开工作详细情况、政府信息公开统计数据、建议提案办理结果公开等内容，并采用公众喜闻乐见的形式予以展现。加强信息公开保密审查制度建设，对拟公开的政府信息，要依法依规做好保密审查。建立健全政府信息公开工作考核评议制度，强化问责制度，定期开展社会调查评议，了解社情民意，不断改进公开工作。建立政府信息公开举报办理工作制度，强化信息公开工作主管部门的监督职责，对经举报查实的有关问题，要严格依据《条例》规定进行处理。地方和部门可根据工作需要在信息公开领域建立政府法律顾问制度，发挥法律顾问专业优势，提高信息公开专业化、法制化水平。\n"
				+ "　　五、加强组织领导和机构队伍建设\n"
				+ "　　各地区各部门要把政府信息公开工作纳入重要议事日程，与经济社会管理工作紧密结合，同步研究、同步部署、同步推进，主要负责同志要主动听取公开工作情况汇报，研究解决突出问题，同时明确一位负责同志分管公开工作。要理顺工作关系，减少职能交叉，加强专门机构建设和人员配备，统筹做好信息公开、政策解读、舆情处置、政府网站、政务微博微信和政府公报等工作，并在经费、设备等方面提供必要保障。把信息公开列入公务员培训科目，加大各级政府尤其是市、县级政府相关工作人员培训力度，不断提升工作能力和水平。\n"
				+ "　　各地区各部门要制定本工作要点分解细化方案，明确分工，加强督导，确保各项任务落实到位。落实情况要纳入政府信息公开工作年度报告并向社会公布，接受公众监督。国务院办公厅适时对本工作要点落实情况进行督查，并组织开展第三方评估。";

		SummaryComputer sc = new SummaryComputer(300, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");

		String[] split = query.split(" ");

		List<Keyword> keywords = new ArrayList<Keyword>();

		for (String kw : split) {
			if (!StringUtil.isBlank(kw)) {
				keywords.add(new Keyword(kw, 100.0d * kw.length()));
			}
		}

		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}

	@Test
	public void test1() {

		String query = "信息公开 工作要点";

		String content = "信息公开,信息公开信息公开,信息公开信息公开,信息公开信息公开,信息公开信息公开,信息公开信息公开,信息公开信息公开,信息公开信息公开,信息公开?"
				+ "sdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsdsdfsdfdslkfjsdklfjlsd?"
				+ "信息公开 工作要点 信息公开 工作要点 信息公开 工作要点 ";

		SummaryComputer sc = new SummaryComputer(15, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");

		String[] split = query.split(" ");

		List<Keyword> keywords = new ArrayList<Keyword>();

		for (String kw : split) {
			if (!StringUtil.isBlank(kw)) {
				keywords.add(new Keyword(kw, 100.0d * kw.length()));
			}
		}

		System.out.println(sc.toSummary(keywords).getSummary());

		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}


	@Test
	public void testVI() {

		String query = "VI";

		String content = "\n" +
				"\\项目开发与服务中心\\VI部";

		SummaryComputer sc = new SummaryComputer(15, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");

		String[] split = query.split(" ");

		List<Keyword> keywords = new ArrayList<Keyword>();

		for (String kw : split) {
			if (!StringUtil.isBlank(kw)) {
				keywords.add(new Keyword(kw, 100.0d * kw.length()));
			}
		}

		System.out.println(sc.toSummary(keywords).getSummary());

		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}

	@Test
	public void test2() {

		String query = "孙明波";

		String content = "　近年来，全市广大专业技术人员认真贯彻落实党的十七大精神，坚持以邓小平理论和“三个代表”重要思想为指导，深入贯彻落实科学发展观，积极投身经济建设、政治建设、文化建设和社会建设，勤奋工作，刻苦攻关，为全市经济社会发展作出了积极贡献，涌现出一批优秀专业技术人才典型。为激发全市广大专业技术人员创新创业，市委、市政府决定，授予丁洪斌等179名同志“青岛专业技术拔尖人才”称号（名单附后），并予以表彰。　　希望受到表彰的同志珍惜荣誉，再接再厉，再创佳绩。全市广大专业技术人员要向专业技术拔尖人才学习，立足本职，开拓进取，为把青岛建设成为富强文明和谐的现代化国际城市作出新的更大贡献。各级党委政府要牢固树立、全面落实科学发展观和人才观，坚定不移地实施“科教兴市”、“人才强市”战略，不断创新人才工作机制，改善人才工作环境，为优秀人才脱颖而出和更好地发挥聪明才智搭建良好平台，为推进“环湾保护、拥湾发展”战略的实施和实现青岛经济社会又好又快发展提供坚强的人才保障和智力支持。　　　　附件：　　2008年度青岛专业技术拔尖人才名单　　（按姓氏笔画排列）　　丁洪斌　青建集团股份公司总裁、工程技术应用研究员、国家一级注册建造师　　于万成　青岛市职业教育公共实训基地教育培训部主任、中学高级教师、数控高级技师　　于良民　中国海洋大学化学化工学院教授　　于俊生　青岛市海慈医疗集团副总院长、主任医师　　于雪初　青岛波尔旺肉业股份有限公司董事长、工程师　　马学真　青岛市肿瘤医院副院长、主任医师、教授　　王　玮　青岛市广播电视局副总编辑，青岛人民广播电台副台长、高级编辑　　王亻凡玉　青岛市普通教育教研室教研员、中学高级教师　　王少华　青岛市市立医院药学部主任、主任药师　　王圣诵　青岛大学法学院院长、教授　　王竹泉　中国海洋大学文科处处长、管理学院副院长、教授　　王志庆　青岛喜盈门双驼轮胎有限公司总经理、高级经济师　　王志斌　青岛大学医学院附属医院心脏超声科主任、主任医师、教授　　王均国　青岛市衡器管理所副所长、工程技术应用研究员　　王绍波　青岛大学美术学院院长、教授　　王金健　青岛高校软控股份有限公司常务副总裁、高级工程师　　王春波　青岛大学医学院人体机能学实验室主任、教授　　王洪仁　青岛双瑞防腐防污工程有限公司总经理助理、高级工程师　　王洪恩　青岛市公安局行动技术支队副调研员、高级工程师　　王振海　中共青岛市委党校副校长、青岛行政学院副院长　　王清印　中国水产科学研究院黄海水产研究所所长、研究员　　王斌贵　中国科学院海洋研究所研究员　　王新强　青岛市机关事务局东部管理中心副总经理、高级技师　　王德宝　青岛科技大学人事处副处长、副教授　　牛同和　胶南市珠海路小学教师、中学高级教师　　牛膺筠　青岛大学医学院附属医院主任医师、教授　　尹凤福　海尔集团技术研发中心绿色设计及资源再生技术研究所所长、高级工程师　　尹衍升　中国海洋大学材料科学与工程研究院院长、教授　　尹焕三　中共青岛市委党校正处级调研员、教授　　石中年　南车青岛四方机车车辆股份有限公司技术工程部副部长、高级工程师　　石兆胜　胶南市职业中专校长、胶南市职教中心主任、青岛电大胶南分校校长、中学高级教师　　左　华　青岛市环境保护科学研究院副院长、教授级高工　　左铁军　青岛市海青机械总厂厂长、高级工程师　　史文伯　海信科龙（广东）空调有限公司总经理助理兼特种空调事业部部长、工程师　　宁　征　青岛市实验幼儿园园长、中学高级教师　　邢泉生　青岛市妇女儿童医疗保健中心儿童医院副院长、主任医师　　吉中强　青岛市海慈医疗集团总院长、主任医师、教授　　吕佩师　青岛海尔洗衣机有限公司总工程师兼全球企划部部长、高级工程师　　曲月锋　青岛市优秀运动队高级教练　　曲立清　青岛国信发展（集团）有限公司国信海底隧道项目筹建处副总经理、研究员　　曲凯先　崂山区中韩街道办事处枯桃社区党委书记、居委会主任，兼任青岛市崂山区枯桃花卉实业有限公司董事长、总经理　　朱　中　青岛海信网络科技公司副总经理、高级工程师　　朱校斌　中国科学院海洋研究所研究员　　刘　晓　中国科学院海洋研究所研究员　　刘占杰　青岛海尔特种电器有限公司本部长、研究员　　刘玉霞　中国海洋大学基础教学中心艺术系副主任、教授　　刘光洲　青岛双瑞防腐防污工程有限公司研发部部长、高级工程师　　刘怀荣　青岛大学文学院副院长、教授　　刘国庆　胶南市畜牧科技指导站研究员　　刘学斌　青岛市公安局网络警察支队支队长、高级工程师　　刘增人　青岛大学鲁迅研究中心主任、教授　　刘德进　中交一航局第二工程有限公司总工程师、高级工程师　　关茜市　南区教育研究指导中心教研员、中学高级教师　　许振超　青岛港前湾集装箱码头有限责任公司工程技术部固机高级经理、高级技师　　孙　勇　青岛大学医学院药剂教研室主任、教授　　孙大庆　青岛市林木种苗站站长、高级工程师　　孙立荣　青岛大学医学院附属医院小儿科副主任兼小儿血液科主任、主任医师、教授　　孙先亮　青岛第二中学校长、中学高级教师　　孙明波　青岛啤酒股份有限公司总裁、工程技术应用研究员　　杜长河　青岛高校信息产业有限公司总裁、高级工程师　　杨为东　青岛即发集团控股有限公司总经理兼技术中心主任、工程师　　李　平　青岛市市政工程集团有限公司总工程师兼市政设计院院长、工程技术应用研究员　　李　杨　青岛市市立医院院长、主任医师　　李　明　青岛海湾集团有限公司总经理，兼任青岛海晶化工集团有限公司董事长、总经理、高级工程师　　李　娜　青岛大学医学院附属医院耳鼻喉科主任、主任医师　　李　琪　中国海洋大学水产学院常务副院长、教授　　李　群　青岛大学应用化学系主任兼应用化学研究所所长、特聘教授　　李卫国　青岛市优秀运动队高级教练兼国家羽毛球队领队、教练　　李文华　青岛市海慈医疗集团影像科主任、主任医师　　李宁毅　青岛大学医学院附属医院主任医师、教授　　李延团　中国海洋大学医药学院副院长、教授　　李成林　山东省海水养殖研究所科研计划与管理办公室主任、副研究员　　李自普　青岛大学医学院附属医院儿科副主任、主任医师、教授　　李志刚　即墨市第二十八中学校长、中学高级教师　　李美华　胶州市振华路小学教师、小学高级教师　　李建英　青岛供电公司调度处自动化班班长、高级工程师、高级技师　　李荣贵　青岛大学医学院生物系主任、教授　　李德爱　青岛市市立医院科研科主任、主任医师　　连新国　青岛市歌舞剧院院长、国家一级导演　　肖国林　青岛海洋地质研究所海洋油气与水合物资源室副主任、研究员　　肖建林　海信集团副总裁　　吴　平　青岛市京剧院名誉院长、国家一级演员　　吴力群　青岛大学医学院外科学教研室主任兼附属医院外科主任、肝胆外科主任、主任医师　　吴乐琴　青岛第二十一中学语文教研组组长、中学高级教师　　吴时国　中国科学院海洋研究所研究员　　邹云雯　青岛大学医学院附属医院骨科主任、主任医师、教授　　沙淑芬　双星集团有限责任公司总工程师、高级工程师　　宋林生　中国科学院海洋研究所研究员　　宋瑞兰　青岛第五十八中教师、中学高级教师　　宋德强　青岛市胶州建设集团有限公司工人、高级技师　　张　博　青岛颐中生物工程有限公司董事长、总经理、高级经济师　　张七一　青岛市市立医院副院长、主任医师　　张士璀　中国海洋大学生命科学与技术学部副主任、教授　　张元信　解放军第四○一医院手外科中心副主任、副主任医师　　张化新　青岛出版社科技出版中心总编辑、编审　　张正欣　青岛饮料集团有限公司董事长、总经理，兼青岛崂山矿泉水有限公司董事长、青岛华东葡萄酿酒有限公司总经理、高级工程师　　张永升　青岛地恩地机电科技股份有限公司董事长　　张志刚　青岛东佳纺机（集团）有限公司总工程师、工程师　　张国防　青岛明月海藻集团有限公司董事长、工程师　　张国辉　青岛市供水管理处处长、工程技术应用研究员　　张荣华　中国石油大学（华东）人文社会科学学院党委书记兼副院长、教授　　张健春　青岛海信电器股份有限公司产品开发部副总经理、高级工程师　　张爱国　青岛英派斯（集团）有限公司总裁、经济师　　张铁柱　青岛大学副校长兼车辆电子技术研究所所长、教授　　张增惠　青岛市体育运动学校田径项目国家级教练兼山东省田径队总教练　　张德奎　青岛市第八人民医院院长助理兼大外科主任、主任医师　　陆　玲　青岛市群众艺术馆文艺部主任、副研究馆员　　陈　戈　中国海洋大学信息科学与工程学院院长、教授　　陈守国　青岛国泰集团有限公司、青岛海生肿瘤医院董事长　　陈西广　中国海洋大学海洋生命学院海洋生物系主任、教授　　陈松林　中国水产科学研究院黄海水产研究所农业部海洋渔业资源可持续利用重点开放实验室常务副主任、研究员　　陈振德　青岛市农业科学研究院党委副书记兼副院长、研究员　　陈索斌　青岛金王集团董事长、高级经济师　　陈常乐　青岛碱业股份有限公司计量仪表处化工仪表与自动化高级技师　　陈维强　青岛海信网络科技股份有限公司总经理、高级工程师　　邵永春　青岛市农业科学研究院副研究员　　迟登亮　中国人民解放军第四八○八工厂轮机车间船舶钳工班长、高级技师　　武鹏崑　青岛首创瑞海水务有限公司总经理、高级工程师　　林　琪　青岛农业大学农学与植物保护学院院长、教授　　林凤章　青岛双桃精细化工（集团）有限公司总经理、高级工程师　　苗志敏　青岛大学医学院附属医院院长、主任医师、教授　　罗　兵　青岛大学医学院微生物学教研室主任、教授　　金显仕　中国水产科学研究院黄海水产研究所副所长、研究员　　金道谟　青岛海尔新材料研发有限公司总经理、高级工程师　　周云杰　海尔集团公司副总裁、高级工程师　　周岩冰　青岛大学医学院附属医院普外科主任、主任医师、教授　　单若冰　青岛市妇女儿童医疗保健中心儿童医院副院长兼新生儿科主任、主任医师　　郑永允　山东省海水养殖研究所副所长、研究员　　郑生春　青岛市勘察测绘研究院副院长、工程技术应用研究员　　建方方　青岛科技大学发展规划处处长、教授　　相佃国　青岛第六十六中学副校长、中学高级教师　　柳学周　中国水产科学研究院黄海水产研究所海水鱼类养殖与设施渔业研究室研究员　　赵东生　中国保险监督管理委员会青岛监管局人身险监管处处长　　赵君财　海信电器股份公司产品引入中心总监、工程师　　赵其圣　海信宽带多媒体技术股份有限公司光模块研发部部长、工程师　　赵铁军　青岛理工大学副校长、教授　　战文斌　中国海洋大学生命科学与技术学部副主任、教授　　修新红　青岛市妇女儿童医疗保健中心妇幼保健所妇保科主任、副主任医师　　逄增昌　青岛市疾病预防控制中心公共卫生顾问、主任医师　　宣世英　青岛市市立医院副院长、主任医师　　姜正俊　青岛云龙纺织机械有限公司董事长、总经理、高级工程师　　姚　军　中国石油大学（华东）石油工程学院院长、教授　　耿以龙　青岛市森林病虫害防治工作站站长　　贾庆鹏　青岛出版社副总编辑、编审　　贾维敏　青岛市胶州建设集团有限公司工人、高级技师　　夏延致　青岛大学纤维新材料与现代纺织国家重点实验室培育基地副主任兼阻燃纤维研究所所长、图书馆馆长、教授　　柴永森　青岛海尔通信有限公司本部长、高级工程师　　徐　建　青岛市胶州中心医院副院长、主任医师　　徐万珉　青岛市社科联党组书记、主席，社科院院长　　徐明振　胶州市农业局总农艺师、高级农艺师　　徐青峰　青岛大学纺织服装学院服装研究所所长、副教授　　徐恭藻　利群集团股份有限公司董事局主席、总裁、高级经济师　　徐殿平　青岛市优秀运动队副队长兼国家女子柔道队领队、国家级教练　　郭　峰　青岛理工大学机械工程学院摩擦学研究所副所长、教授　　郭　锐　南车青岛四方机车车辆股份有限公司首席制造师、钳工高级技师　　郭育晖　市北区教研电教室副主任、小学高级教师　　郭爱青　青岛第十五中学教研组长、中学高级教师　　高汝钦　青岛市卫生监督局局长、主任医师　　栾少湖　德衡律师集团事务所主任　　黄　倢　中国水产科学研究院黄海水产研究所海水养殖生物疾病控制与病原分子生物学实验室主任、研究员　　黄婷婷　青岛市农业科学研究院蔬菜研究所副所长、研究员　　黄　港　青岛市话剧院副院长、国家一级导演　　曹茂永　山东科技大学信息与电气工程学院院长、教授　　曹健伟　青岛海信电器股份有限公司多媒体研发中心专业技术委员会副主任、平台所所长、液晶所所长、工程师　　龚鲁阳　青岛市民族艺术剧院院长助理兼吕剧工作室主任、国家一级演员　　常德传　青岛港（集团）有限公司董事局主席、总裁、高级经济师　　傅　平　青岛市妇女儿童医疗保健中心妇幼保健所副所长、主任医师　　隋学礼　青岛创统科技集团有限公司董事长、总裁　　韩方希　青岛滨海学院院长、副教授　　韩珍德　胶州市向阳路小学校长、中学高级教师　　葛方明　青岛捷能汽轮机集团股份有限公司董事长、总经理、高级经济师　　葛玉钦　胶州市洋河农牧产品研究开发协会会长、高级农艺师　　董　蒨　青岛大学医学院附属医院副院长兼儿科研究所所长、教授　　董晓光　山东省眼科研究所党委书记兼常务副所长、研究员、教授　　喻子达　海尔集团公司副总裁、高级工程师　　翟广顺　青岛市教育科学研究所所长、研究员　　翟翌立　青岛海尔电子有限公司总工程师　　戴淑真　青岛大学医学院附属医院妇产科主任、教授　　魏立青　青岛市公安局刑警支队技术处五科科长、高级工程师";

		SummaryComputer sc = new SummaryComputer(200, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");

		String[] split = query.split(" ");

		List<Keyword> keywords = new ArrayList<Keyword>();

		for (String kw : split) {
			if (!StringUtil.isBlank(kw)) {
				keywords.add(new Keyword(kw, 100.0d * kw.length()));
			}
		}

		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}

	@Test
	public void test4() {

		TagContent tc = new TagContent("<begin>", "<end>");


		String content = "您好,         1986年出国留学,2008年回国后 发现户口被注销(本人不知情),当时出国时还没有办理身份证,去入户派出所查询,只有入户的信息,其他材料一概没有,甚至没有所谓的注销情况之类(据说期间材料被转过三个派出所,最大可能是派出所转移时候遗失.现在是几个派出所互相推,) ,    1,这种情况我如何恢复户籍??没有身份证在中国处处不方便..    2,我有国外永久居留,如恢复的话是否可以保留?        谢谢";

		List<Keyword> keywords = new ArrayList<>();

		keywords.add(new Keyword("中国", 2d));
		keywords.add(new Keyword("信息", 2d));

		SummaryComputer sc = new SummaryComputer(22, true, "", content);
		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}

	@Test
	public void englishWordTest() {
		String query = "plasma";

		String content = "Aerodynamic Control of High Performance Aircraft Using Pulsed Plasma Actuators";

		SummaryComputer sc = new SummaryComputer(200, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");

		String[] split = query.split(" ");

		List<Keyword> keywords = new ArrayList<Keyword>();

		for (String kw : split) {
			if (!StringUtil.isBlank(kw)) {
				keywords.add(new Keyword(kw, 100.0d * kw.length()));
			}
		}

		String tagContent = tc.tagContent(sc.toSummary(keywords));

		System.out.println(tagContent);
	}


	@Test
	public void testHighlight() {

		Forest forest = new Forest() ;
		forest.add("nuclear",null);

		System.out.println(forest.getWord("联系邮箱 ：Nuclear_net@163.com\n").getFrontWords()); ;


		String content = "中国核网\n" +
				"         | 核行业必读的公众号\n" +
				"       \n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"    \n" +
				"   \n" +
				"   \n" +
				"    \n" +
				"     \n" +
				"      \n" +
				"       人类未来殖民火星的日子，靠太阳能发电落伍了，美国太空总署（NASA）自 2015 年起启动名为“Kilopower”的计划后，便打算让核能站在火星能源的舞台中央。现在，该计划下制造的微型核分裂反应堆将正式送往美国能源部的内华达国家安全区进行一系列评估测试。\n" +
				"\n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    ▲火星表面系统的概念图\n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    据悉，本月，美国宇航局（NASA）将开始在内达华州测试火星探测用“核动力装置”，该装置可以为火星表面上的宇航员提供动力。据报道，这种发电装置只有卫生纸卷铀大小，通过一个高效率的斯特林发动机转换成电力，最终以汽车发动机类似的方式进行高效工作。\n" +
				"\n" +
				"    NASA的空间技术任务理事会（STMD）已经为Kilopower项目提供了多年的资助。该项目的目标是开发一种“低成本、可扩展的裂变动力系统”，为太空任务提供动力。研究人员估计火星表面任务总共需要大约40kW的功率。根据美国宇航局的数据，这一数量的能源可以为“地球上的八座房屋”提供动力。1.9米（6.5英尺）高的Kilopower反应堆每个都设计为向航天器提供1-10 kW的电力。由于核裂变，有4个或5个Kilopower反应堆，NASA可以为一个火星殖民地提供动力，运行所有必要的设备来生产燃料，清洁空气和水，并对所有电池充电。\n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    “Kilopower测试计划将使我们相信这项技术已经可以用于太空的探索。”STMD公司NASA总部电力和能源首席技术专家Lee Mason说：“我们将分析模型，以验证硬件的运行情况。”位于田纳西州橡树岭的Y12国家安全中心正在为该系统的测试提供的反应堆堆芯做准备。Mason声称“拥有太空级裂变能的火星探险家将是游戏规则的改变者。” \n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    此前，NASA使用的Pu-238放射性同位素热电发电机（RTG）已经为好奇心，旅行者和卡西尼提供电力，但是它们只有110瓦。Mason也称：“放射性同位素热发电机（RTG）通常只能提供几百瓦左右的功率，而我们正在努力给太空任务提供一个非RTG的选项。这项新技术可以提供几千瓦，数百千瓦，甚至是兆瓦的电力。这也就是我们说的“Kilopower技术”。\n" +
				"\n" +
				"    Kilopower技术可在满足火星的电力需求同时，不受夜间或者由太阳光照引起沙尘暴的影响。不管在火星上的任何位置，包括可能存在冰层的北部高纬度地区，Kilopower技术都为火星表面提供高能量密度的电源，这将进一步扩大探测器在火星上可能的着陆点。且由于尺寸足够小，多个装置可以同时部署在一个火星着陆器上，且每个单元可独立完成火星表面任务。\n" +
				"\n" +
				"    “正在测试的反应堆技术可能适用于多个美国宇航局的任务，我们希望这是裂变反应堆开创太空探索的新模式的第一步”洛斯阿拉莫斯首席执行官、反应堆设计者大卫·波斯顿（David Poston）说。\n" +
				"\n" +
				"    NASA将与美国能源部（DOE）内华达州国家安全局合作评估这项裂变电源技术。测试原计划于今年9月份开始，但由于种种原因，推迟到11月份，自今年 11 月起到明年初，太空核反应堆将送往美国能源部辖下的内华达国家安全区（Nevada National Security Site）进行一系列测试，这项技术是否安全与可靠，将交由能源部的专业设施和洛斯阿拉莫斯国家实验室的工程师评估。测试完成后，美国宇航局将对该技术进行评估以研究其未来的计划。\n" +
				"\n" +
				"    不过，尽管 Kilopower 具潜在实用性，但要将数十个微型核反应堆送入火星仍引起相当人士的担忧，即便它们只是「小型」核反应堆、防故障系统保证几乎万无一失。外界认为，火星上的核反应堆发生灾难性事故的风险，就和日本福岛发生的核事故一样不可预测，也许内华达国家安全区的测试应展示出 Kilopower 系统如何处理全面系统性故障问题。\n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    参考来源：\n" +
				"\n" +
				"    \tNASA reveals 'nuclear engine' that could provide power to the first humans on Mars\n" +
				"http://Nuclear-engines.html\n" +
				"\n" +
				"\n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"     \n" +
				"      \n" +
				"       声明\n" +
				"\n" +
				"       以上内容由中国核网整理\n" +
				"\n" +
				"       转载请注明出处：“中国核网” \n" +
				"\n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    近期热点\n" +
				" \n" +
				"   \n" +
				"   \n" +
				"    \n" +
				"     \n" +
				"      \n" +
				"       \tNASA：重启热核火箭计划，核发动机或助推“火星之旅”\n" +
				"\n" +
				"\n" +
				"\t华龙一号英国通用设计审查(GDA)正式进入第二阶段\n" +
				"\n" +
				"\n" +
				"\t国际能源署：到2040年，核能将至少提供全球15%的电力\n" +
				"\n" +
				"\n" +
				"\t西屋中国挑战：三门、海阳项目进展缓慢，暂无新签订单\n" +
				"\n" +
				"\n" +
				"\t中核集团总经理钱智民:中美核能领域合作潜力非常大\n" +
				"\n" +
				"\n" +
				"\n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    \n" +
				"     \n" +
				"      \n" +
				"       汇集核能资讯\n" +
				"\n" +
				"       服务核能发展\n" +
				"\n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"    \n" +
				"     \n" +
				"      \n" +
				"       \n" +
				"        \n" +
				"         \n" +
				"          \n" +
				"         \n" +
				"        \n" +
				"       \n" +
				"       \n" +
				"        \n" +
				"         \n" +
				"         \n" +
				"        \n" +
				"       \n" +
				"       \n" +
				"        \n" +
				"         \n" +
				"           中·国·核·网\n" +
				"\n" +
				"         \n" +
				"        \n" +
				"       \n" +
				"       \n" +
				"        \n" +
				"         \n" +
				"        \n" +
				"       \n" +
				"       \n" +
				"        \n" +
				"         \n" +
				"          联系邮箱 ：nuclear_net@163.com\n" +
				"\n" +
				"         \n" +
				"        \n" +
				"       \n" +
				"      \n" +
				"     \n" +
				"    \n" +
				"   \n" +
				"  \n" +
				" \n" +
				" \n" +
				"  \n" +
				"   \n" +
				"    ✬点击阅读原文查看更多资讯✬\n" +
				"\n" +
				"   \n" +
				"  \n" +
				" \n";



		boolean single = true ;

		HashSet<String> kwSet = new HashSet<>() ;


		Result nuclear = DicAnalysis.parse("nuclear");

		for (Term t : nuclear){
			if (!",".equals(t.getName()) && (single || t.getName().length() > 0)) { //skip lenth 1
				kwSet.add(t.getName());
			}
		}


		if (kwSet == null || kwSet.size() == 0) {
			kwSet.add("ANSJ_NOT_HAVE_CONTENT");
		}

		List<Keyword> keywords = new ArrayList<>();

		for (String s : kwSet){
			keywords.add(new Keyword(s.toLowerCase(), s.length() * s.length() * 10)) ;
		}



		TagContent tc = new TagContent("<begin>", "<end>");


		SummaryComputer sc = new SummaryComputer(100, true, null, content);


		System.out.println(tc.tagContent(sc.toSummary(keywords))); ;


		System.out.println("gine' that could provide power to the first humans on Mars http://www.dailymail.co.uk/sciencetech/article-508".length());

	}


	@Test
	public void test3() {
		String query = "创新管理";

		String[] split = query.split(",");

		HashSet<String> kws = new HashSet<>() ;

		for (String str : split) {
			kws.add(str) ;
			for (Term t : ToAnalysis.parse(str)) {
				kws.add(t.getName()) ;
			}
		}

		String content = "英富森参考消息报半年度工作总结\n\n经过为期半年的资料收集（2016年3月下旬-9月上旬），《英富森参考消息报》在行业动态、招投标信息、竞争对手动态等方面的信息有了一定数据和内容积累。为了更好的对公司和各部门在了解行业、预判市场、感知竞争等方面起到一定的参考价值，现将半年信息做了整合汇编和系统全面性的总结、梳理。\n1、 数据报告\n1、行业动态\n\t行业动态\n\n\t行业分类\n\t文章篇数\n\n\t教科文\n\t23\n\n\t政企\n\t34\n\n\t医疗\n\t8\n\n\t信息科技\n\t9\n\n\t合计\n\t74\n\n\t备注：含国内57篇、国际17篇\n\n\t文章类型：国家政策、专家观点、成功案例、领导讲话、技术分享、调研报告、会议精神等\n\n\n\n2、招中标信息\n\t招中标信息\n\n\t行业分类\n\t招标数量\n\t中标数量\n\t合计\n\n\t教科文\n\t78\n\t118\n\t196\n\n\t政企\n\t56\n\t60\n\t116\n\n\t合计\n\t134\n\t178\n\t312\n\n\n\n\n3、竞争对手的动态\n\t竞争对手\n\n\t单位简称\n\t中标数量\n\t中标总金额（万元）\n\t官网新闻数量\n\n\t九瑞\n\t7\n\t840\n\t0\n\n\t拓尔思\n\t19\n\t2562\n\t14\n\n\t同方知网\n\t53\n\t2114\n\t14\n\n\t万方数据\n\t32\n\t723\n\t0\n\n\t超星\n\t36\n\t1112\n\t0\n\n\t广州图创\n\t4\n\t175\n\t1\n\n\t久其\n\t22\n\t1099\n\t15\n\n\t蓝凌\n\t1\n\t93\n\t27\n\n\tSAP\n\t0\n\t0\n\t43\n\n\t国脉互联\n\t3\n\t142\n\t19\n\n\n2、 行业解读\n1、教科文\n当今世界，科技进步日新月异，互联网、云计算、大数据等现代信息技术深刻改变着人类的思维、生产、生活、学习方式。随着信息技术在教育领域的不断渗透，生态化、网络化、分散的、生命化的个性化教育将会成为未来教育的发展趋势。构建网络化、数字化、个性化、终身化的教育体系，建设“人人皆学、处处能学、时时可学”的学习型社会，是人类共同面临的重大课题。英富森当以教育信息化推动高水平大学建设，实现学习数字化、科研信息化、管理服务信息化。\n关键词：\n教育信息化、教育改革、数字时代、图书馆模式、教育大数据、互联网+教育、教育+互联网、公共图书馆、数字图书馆、移动图书馆\n文章类型：\n教育信息化趋势格局、政策文件通知、国家领导讲话、国外图书馆服务与经验、专家观点分析、公共与高校图书馆形势、移动图书馆应用\n重要文章：\n《教育信息化改革中国教育资源格局》《公共图书馆面临转型挑战》《图书馆移动服务在国外大学的状况》《教育部关于印发<教育信息化“十三五”规划>的通知》《张连城：“互联网+”和高校管理服务的新思维》《国内高校移动图书馆现状及发展趋势》《教育信息化的国际趋势与启示》《教育部关于印发<推进“一带一路”教育行动>的通知》《大数据背景下的高职院校信息化建设探索》\n要点解读：\n1）目前我国教育信息化行业正处于快速发展期向行业整合期过渡阶段，随着移动互联网的发展,各家争夺的战场逐步移到移动端。\n2）教育大数据不仅仅是数据本身的大小描述，而是由数据引发的各种关联工作和解决方案。教育大数据就是教育统计插上了信息化的翅膀，变得比统计和信息化本身对人类更有价值。\n3）目前教育大数据的采集网络仍处于布局和建构的初级阶段，大数据在教育决策、教学过程中的运用还处于摸索和起步阶段，大数据人才培养的完善体系还没有建立起来。\n4）中国的信息资源共享平台存在着全国性信息资源共享平台开放力度不够，省级平台缺乏统一的建设规范与标准，对知识产权保护意识不够的问题。\n5）根据国家规定与学校需求建设资源平台，提供优质服务，积极利用云计算、大数据等新技术，创新资源平台，管理平台的建设、应用模式。\n6）“互联网+教育”，其实质是构建一个高校网络的生态域，即“人人皆学、处处能学、时时可学”。“互联网+高校”要深入高校更多的核心业务领域，产生大量“化学反应式”的融合与创新，推动机构重组与流程再造。\n7）移动图书馆的最大特点与优势就是可以方便地为用户提供个性化信息服务。如何从用户的需求出发，按照用户的个性化需要来组合移动图书馆的界面元素，逐步提升和完善个性化服务，是今后移动图书馆“应需而变”的发展趋势。\n2、政企\n2015年，李克强总理将“互联网+”行动计划纳入政府工作报告，“互联网+”作为一种以现代信息产业为主导的新型经济形态，正不断冲击着传统的政府管理理念和运作模式，推动政府信息化管理向高效化、无缝隙化、透明化和市场化方向发展。这显然会对我国的政府信息化建设提出更为严峻的挑战，只有积极创新信息化管理方式，加快政府服务转型，才能适应新时代对政府信息化管理能力的新要求。\n关键词：\n政府决策、政府服务、政务数据资源、互联网+政务服务、政府公共政策、政府信息化、服务型政府、电子政务、政务云\n文章类型：\n信息化建设经验、信息资源共享的观点、国外电子政务要点与实践、电子政务发展特点、政府之声、政府工作要点、政务发展理念、政务服务的国家级会议、政务发展新政策\n重要文章：\n《世界主要国家信息化建设基本经验概括》《政务数据资源体系建设思考》《大数据时代下政府部门间信息资源共享的思考》《政府公共政策协商的国际经验和中国实践》《“互联网+政务”：内涵、形势与任务》《国外公共服务体系建设与我国建设服务型政府》《2015年中国电子政务发展呈现六大特点》《李克强主持召开国务院常务会议部署加快推进“互联网+政务服务”》\n要点解读：\n1） 世界主要国家对信息资源的开发与管理正走向多元共享和数据开放，并通过数据开放不断提升政府公共服务。\n2） “互联网+政务”是利用“互联网+”的思维，整合政务信息、分享政务信息，创新管理和服务模式，进而改善民众的生活水平和质量。“互联网+政府服务”平台是向社会提供新模式、新境界、新治理结构下的管理和政务服务产品，推进行政体制改革、转变政府职能，简政放权、放管结合、优化服务的“先手棋”，做到便捷化、个性化、精准化。\n3） 部分地方政府除政府网站外还借助云计算、移动互联网、物联网、大数据等新技术探索和培育适应互联网新趋势的在线服务模式，实现政府服务的智慧化转型，形成三类比较有代表性的服务模式。一是基于O2O的服务场景融合。二是多媒一体的服务渠道融合。三是基于社会化的网络服务平台整合。\n4） 大力推行“互联网+政务服务”，推进实体政务大厅向网上办事大厅延伸，打造政务服务“一张网”，简化服务流程，创新服务方式，对企业和群众办事实行“一口受理”、全程服务。制定政府部门间数据信息共享实施方案，明确共享平台、标准、目录、管理、责任等要求，打破“信息孤岛”和数据壁垒，实现数据信息互联互通和充分共享，建设高效运行的服务型政府。\n5） 开放共享政府数据，让这些数据真正发挥价值，实现高效、快捷而又完备的政务服务，需要落实三步走。第一步是“业务上云”。通过云计算将政府业务进行整合，打通信息孤岛，为政务数据的交换共享提供基础。第二步是“数据整合”。搭建可以对外提供支撑服务的大数据中心或平台，该大数据中心或平台可以支撑政府的决策、提高政府的效率、改善政府的治理结构，同时更能够支撑政府对社会的便民服务、支撑中小微企业创新创业的发展。第三步是“业务创新”。政府部门结合不同业务的需要、不同领域的需要以大数据中心或平台为纽带和企业一起，实现应用创新。\n3、医疗\n中共中央政治局8月26日召开会议，审议通过“健康中国2030”规划纲要。该纲要是今后15年推进健康中国建设的行动纲领。纲要指出坚持健康优先、改革创新、科学发展、公平公正的原则，把健康融入所有政策，全方位、全周期保障人民健康，大幅提高健康水平，显著改善健康公平。对此，完善人口健康信息服务体系建设，推进健康医疗大数据应用成为重要举措。大数据等信息技术有望成为缓解医患纠纷、提升患者就医体验、提高医疗机构服务水平新的突破口。\n关键词：\n移动医疗、智慧医疗、互联网医疗、医疗信息化\n文章类型：\n医疗趋势布局走向、医疗研究发展报告发布、云医院平台案例\n重要文章：\n《王有才：未来医疗信息化四大走向》《中国移动医疗市场年度研究报告2016》\n要点解读：\n1）未来医疗信息化面临四大走向，主要有大众健康、支持医改、健康社区、科研创新。\n2）中国互联网医疗市场处于启动期，在移动医疗服务优化中探索商业模式。\n3、 公开招标、中标信息\n招标形式90%以上为公开招标，其他还包括竞争性谈判和单一来源。\n1、 教科文招中标\n\n\t教科文招中标情况\n\n\t图书馆分类\n\t招标数量\n\t中标数量\n\n\t高校图书馆\n\t31\n\t56\n\n\t公共图书馆\n\t41\n\t42\n\n\t合计\n\t72\n\t98\n\n\n\n\t高校图书馆招标情况\n\n\t采购单位\n\t清华大学、广东海洋大学、吉林师范大学、北京信息科技大学、陕西理工大学、河北医科大学等\n\n\t投标项目类型\n\t图书馆公共服务平台建设、数字文献信息资源共享平台、移动图书馆云检索服务系统、图书馆信息化平台、智慧图书馆系统、数字化校园建设等\n\n\t投标预算\n\t6万元-600万元不等，以10-20万元左右、100万元左右居多\n\n\t投标集中地域\n\t北京、山东、河北、福建、广东、吉林、甘肃、上海、云南、陕西等\n\n\t公共图书馆招标情况\n\n\t采购单位\n\t山东省图书馆、上海图书馆、河北省图书馆、浙江图书馆、佛山市图书馆、国家图书馆、曲靖市图书馆、云南省图书馆等\n\n\t投标项目类型\n\t数字图书馆资源建设、移动图书馆、公共数字文化支撑平台、智慧资源建设等\n\n\t投标预算\n\t10万元-700万元不等，以200万元左右居多\n\n\t投标集中地域\n\t北京、山东、河北、福建、广东、吉林、甘肃、上海、云南、江西、四川、河南、浙江、贵州、广西等\n\n\n\n\n\t高校图书馆中标情况\n\n\t采购单位\n\t北京交通大学、齐鲁工业大学、贵州大学、山东师范大学、河北医科大学、青岛理工大学、北京信息职业技术学院、北方工业大学、上海商学院、北京联合大学、华东政法大学、陕西理工大学等\n\n\t中标厂商\n\t北明软件、超星、万方数据、同方知网、九星时代、上海理想信息产业等\n\n\t中标价\n\t4万元-180万元不等，以10万元左右居多\n\n\t主要中标项目\n\t北京交通大学图书馆公共服务平台建设、2016年本科高等综合水平提升-数字图书馆资源建设项目、改善办学条件-信息化建设-移动图书馆云检索服务系统建设、上海电子信息职业技术学院高等职业教育知识服务平台项目等\n\n\t中标集中地域\n\t北京、山东、河北、福建、广东、吉林、甘肃、上海、陕西、贵州、江西、安徽、四川、内蒙古、广西、宁夏等\n\n\t公共图书馆中标情况\n\n\t采购单位\n\t余姚市图书馆、福建省图书馆、首都图书馆、遵义市图书馆、贵州省图书馆、上海图书馆、国家图书馆、敦煌市图书馆、云南省图书馆、甘肃省图书馆等\n\n\t中标厂商\n\t超星、太极计算机股份、万方数据、今朝在线、同方知网、四川云图、广州图创、拓尔思、云南软数、重庆维普、昆明联图等\n\n\t中标价\n\t10万元-780万元不等，以20万元-70万元左右居多\n\n\t主要中标项目\n\t周口市图书馆公共文件数字化建设、贵州省图书馆数字资源建设项目、首都图书馆移动图书馆项目、国家图书馆2016年度中国政府公开信息资源整合服务平台分站建设项目、泰顺县图书馆信息化建设、甘肃省图书馆公共数字文化支撑平台基础软件系统项目等\n\n\t中标集中地域\n\t北京、山东、河北、福建、广东、吉林、甘肃、上海、浙江、河南、贵州、广西、云南、江西、青海等\n\n\n2、政府招中标\n\t政府招标情况\n\n\t采购单位\n\t贵州省人民政府办公厅、龙州县人民政府办公室、东莞市电子政务办公室、佛山市禅城区行政服务中心、绥化市公安局、厦门市经济技术中心、义乌市电子政务办公室、徐汇政府门户网运行管理中心、郑州市数字城市办公室、北京市朝阳区信息化工作办公室、焦作市公安局、梅州市经济和信息化局等\n\n\t投标项目类型\n\t信息资源共享公共云服务平台、电子政务系统软件开发、政务大数据软件开发、网上政务智能搜索服务、电子政务云平台建设、政务云安全协同平台等\n\n\t投标预算\n\t10万元-3200万元不等，以100万元-400万元居多\n\n\t投标集中地域\n\t北京、山东、河北、福建、广东、上海、浙江、河南、贵州、广西、云南、江西、黑龙江、安徽、内蒙古、海南、宁夏、四川、湖北、陕西等\n\n\t政府中标情况\n\n\t采购单位\n\t上海市普陀区信息中心、邹平县人民政府办公室、贵州省人民政府办公厅、龙州县人民政府办公室、徐汇政府门户网运行管理中心、揭阳市电子政务管理办公室、广东省水利厅政务服务中心等\n\n\t中标厂商\n\t上海互联网软件、浪潮软件、山东智维信息、东软集团、久其、北京开普互联、北京科华万象、拓尔思、中通服网络、太极计算机、北京龙源创新、亚信科技、国脉互联、河南九洲、蓝凌等\n\n\t中标价\n\t10万元-12000万元不等，以100万元-300万元居多\n\n\t主要中标项目\n\t2016年普陀区电子政务平台应用系统运维服务项目、邹平县电子政务外网平台（一期）项目建设项目、国家发展改革委网上政务服务大厅（一期）建设项目、2016年贵州省政府网站、电子政务网评估及政府网站云监测项目、龙州县人民政府办公室电子政务系统软件开发、白银市政府门户网建设项目、网上政务服务智能搜索服务项目等\n\n\t中标集中地域\n\t北京、山东、河北、广东、上海、浙江、河南、贵州、广西、云南、江西、甘肃、陕西、海南、宁夏等\n\n\n\n4、 竞争对手信息\n1、九瑞\n1）中标项目\n共计4项，包括中国水产科学研究院信息资源共建共享管理系统软件及服务等，约中金额840万元。\n2、拓尔思\n1）中标项目（20项）\n\t序号\n\t中标公告日期\n\t中标项目\n\t中标金额（万元）\n\n\t1\n\t2016/4/27\n\t中国共产党云南省委员会办公厅2015年电子政务运维项目\n\t22\n\n\t2\n\t2016/5/9\n\t北京市科学技术情报研究所面向文本信息的情报处理及分析能力建设政府采购项目（第五包—第十包）\n\t24\n\n\t3\n\t2016/5/27\n\t财政部门户网站运行维护项目\n\t66.5\n\n\t4\n\t2016/5/27\n\t甘肃静宁门户网站改版开发\n\t25.6\n\n\t5\n\t2016/5/23\n\t环境保护部网站内容发布平台软件采购项目\n\t133.55\n\n\t6\n\t2016/6/30\n\t《中国战略新兴产业》杂志社有限责任公司中国战略性新兴产业信息聚合传播平台建设项目\n\t220\n\n\t7\n\t2016/6/28\n\t中国美术馆网站建设项目\n\t27.69\n\n\t8\n\t2016/6/29\n\t广东省国土资源“数字档案室”建设项目\n\t72.8\n\n\t9\n\t2016/6/23\n\t工业和信息化部电信研究院移动互联网与智能终端公共服务平台公共服务统一门户项目\n\t124.5\n\n\t10\n\t2016/7/14\n\t白银市政府门户网建设项目\n\t27.79\n\n\t11\n\t2016/7/13\n\t新华社舆情系统代维服务\n\t29\n\n\t12\n\t2016/7/8\n\t浦经济开发区公安局情报作战平台建设及外网数据采集系统（A包）\n\t33.7\n\n\t13\n\t2016/7/7\n\t工业和信息化部电信研究院ICT信息分析共享与决策支持云平台升级-升级建设ICT信息分析共享与决策支持云平台门户系统开发项目\n\t133\n\n\t14\n\t2016/7/22\n\t宁夏日报报业集团数字全媒体项目1期——媒体融合生产和大数据服务平台\n\t1050\n\n\t15\n\t2016/8/5\n\t中国装备制造业智能知识库及企业应用平台开发\n\t206.48\n\n\t16\n\t2016/8/23\n\t广东省人大常委会信息系统升级维护服务采购项目\n\t42\n\n\t17\n\t2016/9/9\n\t北京市统计局计算中心统计信息化运行维护费\n\t81.95\n\n\t18\n\t2016/9/8\n\t国土资源部信息中心地质矿产资源资料类网上数据服务建设项目\n\t138.8\n\n\t19\n\t2016/9/7\n\t国土资源部土地整治中心网站内容发布管理平台采购项目\n\t43.35\n\n\t20\n\t2016/9/5\n\t广东省水利厅门户网站支撑平台升级项目\n\t60\n\n\t合计\n\t　\n\t　\n\t2562.71\n\n\n2）新产品\n拓尔思整合最新市场应用案例及功能推出新版TRS SMAS聚网大数据分析平台，基于云服务模式实现对互联网信息的智能洞察。\n3）官网新闻\n共计发布7篇\n4）出席会议\n\t拓尔思出席会议概览（25场）\n\t演讲主题\n（宣传产品）\n\n\t全国报社新闻技术工作会议暨2016中国报业技术年会\n\t《媒体转型之路的技术实践》\n思图云平台\n\n\t全国知识图谱与语义计算大会\n\t《拓尔思水晶球——基于动态本体的知识管理工具》\n\n\t拓尔思集团公安行业2016交流会（主办）\n\t水晶球分析师平台\n\n\t“探精致城市、访文化古道”百名社长看常熟新闻采风活动暨中国新闻技术工作者联合会县市区域新媒体分会成立大会\n\t《基于大数据的媒体融合生产与服务》\n小思机器人、TRS数家服务系统、TRS思图云平台\n\n\t中国政务舆情绿岛论坛\n\t《互联网+大数据驱动的舆情变革与发展》\nTRS互联网舆情管理系统（简称TRS OM）\n拓尔思用户绿岛舆情研究所正式揭牌\n\n\t全国报刊媒体融合创新案例路演\n\t拓尔思助力浙江日报报业集团媒体融合转型创新位列第一\n\n\t2016内蒙古‘互联网+政务’创新趋势研讨会\n\t《大数据—互联网时代政府发展的引擎》\nTRS政府公共服务平台、打击非法集资平台\n\n\t2016第六届中国SEO排行榜大会（主办）\n\t《营销4.0定义未来》\n\n\t媒体融合高层发展论坛\n\t《技术支撑移动互联网时代的媒体融合》\n\n\t中国新闻技术工作者联合会六届三次理事会、2016年学术年会暨《王选新闻科学技术奖》和优秀论文奖颁奖大会\n\t《媒体融合转型之路：从技术创新到运营增效》\n融媒体智能生产与传播服务平台解决方案\n\n\t2016未来媒体沙龙——媒体融合的实战路径\n\t《技术驱动媒体融合发展》\n\n\t第二届军民融合技术装备博览会\n\t大数据云搜解决方案、集约化智能系统的拓尔思一站式公共服务平台\n\n\t清华大数据思享会\n\t《大数据时代政府监管与服务转型》\n\n\t2016中国“互联网+政务”创新趋势巡回研讨会北京站\n\t政府在线名誉管理策略\n\n\t首届晨晖资本LP年会\n\t大知识、物联网和人工智能\n\n\t中关村军民融合产业园第三期中关村西郊论坛\n\t《增强共识，聚焦行动》\n\n\t2016年贵阳国际大数据产业博览会\n\t海贝大数据管理系统、水晶分布式数据库系统、大数据舆情分析平台\n\n\t2016年电子货币与分布式总帐技术对银行业务管理影响研讨会\n\t《大数据风控和监管》\nTRS金融大数据解决方案\n\n\t2016中国（青海）‘互联网+政务’创新趋势研讨会\n\t《“互联网＋”时代的政府网站集约化建设思路》\nTRS集约化云平台\n\n\t第十九届中国北京国际科技产业博览会\n\tTRS SMAS社会媒体分析云服务平台、TRS 思图云平台\n\n\t第二届中国数据新闻大赛暨“一带一路”传媒高峰论坛\n\t《基于大数据的智能传播服务平台》\n中央厨房\n\n\tRONG论坛之“大数据与公共安全”专场\n\t《洞见数据内涵，提升公共安全研判能力》\n安全领域大数据云搜索解决方案\n\n\t中国报协五届二次理事会暨中国报业发展大会\n\t《大数据支撑中央厨房生产服务》\n中央厨房\n\n\t2016中国‘互联网+政务’创新趋势研讨会佛山站\n\t《用大数据和云计算构建互联网时代政府公共服务平台》\n一站式公共服务平台\n\n\t军民融合协同创新西郊论坛\n\t面向军事应用的大数据融合与分析平台、舆情监测演示系统\n\n\n3、同方知网\n1）中标项目\n共计53项，包括2016年本科高校综合水平提升-数字图书馆资源建设项目、首都图书馆“移动图书馆”项目、2016年安徽电大数字图书馆建设项目、松原市宁江区文化馆数字图书馆项目、上海电子信息职业技术学院高等职业教育知识服务平台竞争性谈判项目等，约中金额2114万元。\n2）官网新闻\n共计发布3篇\n3）出席会议\n\t同方知网出席会议概览（25场）\n\n\t首届职业院校图书馆服务创新论坛暨中国图书馆学会高职分会成立大会\n\n\t2016首届全国高校创新管理研究与教学研讨会\n\n\t辽宁镁产业协同创新暨科技成果对接签约仪式\n\n\t面向信息化建设的知识管理与大数据应用研讨会\n\n\t基于大数据的协同研究与智库建设研讨会\n\n\t知识管理助推企业智库创新高端论坛\n\n\t科技查新助力企业科技创新研讨会\n\n\t2016年高校图书馆知识服务与创新应用高级研修班\n\n\tCNKI科研管理与情报工作学术研讨会\n\n\t第七届中国博物馆及相关产品与技术博览会\n\n\t一带一路’与中国出版业‘走出去’研讨会\n\n\t北汽‘CNKI汽车企业知识管理与协同创新平台’体验交流会\n\n\t第二十三届北京国际图书博览会\n\n\t2016年全国检察机关科技装备展\n\n\t第21届欧洲汉学学会（EACS）双年会议\n\n\t中国法学会法学期刊研究会会员代表大会暨2016年学术研讨会\n\n\t机构知识管理与协同创新平台演示体验会\n\n\t出版融合、促进区域创新发展研讨会\n\n\t2016年数字出版与数字图书馆融合发展国际研讨会（CDPDL）\n\n\t2016年鲁南地区高校图书馆转型发展与服务创新研讨会\n\n\t互联网+医疗知识创新研讨会暨齐齐哈尔市医学会医学科研管理专业委员会与齐齐哈尔市医学临床教育专业委员会年会\n\n\t第八届亚洲犯罪学学会年会\n\n\t2016中国汽车企业知识管理平台建设与应用研讨会”\n\n\t中国（银川）国际智能工厂技术与设备展览会\n\n\t水利水电机构知识管理平台、水利计算软件和BIM云服务技术研讨会\n\n\n4、万方数据\n1）中标项目\n共计32项，包括中央档案馆图书资料数字资源管理系统建设项目、冶金工业信息标准研究院冶金知识服务平台建设项目等，约中金额723万元。\n2）出席会议\n\t万方数据出席会议概览（6场）\n\n\t第十四届（2016）全国核心期刊与期刊国际化、网络化研讨会\n\n\t互联网+时代下的高校图书馆转型高峰论坛\n\n\t2016年中国高校图书馆发展论坛\n\n\t2016年吉林省数图新服务应用研讨班\n\n\t2016年兰州市数图新服务应用研讨班\n\n\t2016年天津市数图新服务应用研讨班\n\n\n5、超星\n1）中标项目\n共计36项，包括周口市图书馆公共文化数字化建设、甘肃省图书馆数字图书馆推广工程数字资源联合建设地方文献数字化项目、平潭县图书馆移动知识空间服务系统采购项目等，约中金额1112万元。\n6、广州图创\n1）中标项目\n中标项目共计4项，包括泰顺县图书馆信息化建设、智慧图书馆项目等，约中金额175万元。\n2）出席会议\n共计参加会议1场，文化产业博览交易会。\n7、久其\n1）中标项目\n共计22项，包括公民科学素质决策分析系统建设项目等，约中金额1099万元。\n2）官网新闻\n共计发布13篇。\n2）出席会议\n\t久其出席会议概览（6场）\n\n\t2016年度军工财会及项目投资管理培训班\n\n\t第八届中国行业信息化奖项评选活动暨2016中国行业信息化发展高峰论坛\n\n\t2016媒体融合大会\n\n\t2016中国大数据产业生态大会暨中国大数据产业生态联盟成立大会\n\n\t2016年久其电子政务论坛\n\n\t2016数博会\n\n\n8、蓝凌\n1）中标项目\n共计1项，包括公安部物证鉴定中心知识管理系统建设项目，约中金额93万元。\n2）官网新闻\n官网发布新闻动态23篇。\n3）出席会议\n\t蓝凌出席会议概览（4场）\n\n\t蓝凌移动互联典型案例百城共享会\n\n\t第五届浙江CIO峰会\n\n\t探索‘互联网+制造’之路，智造时代创新力城市CIO沙龙\n\n\t2016云栖大会-深圳峰会\n\n\n9、SAP\n1）官网新闻\n共计发布8篇。\n2）出席会议\n\tSAP出席会议概览（9场）\n\n\t2016 SAP中国峰会\n\n\tSAP 首届中国学术年会\n\n\t第二届“至真•智美”商业女性高峰论坛\n\n\t\"数字经济下的商业重构\"的SAP|华为 论坛\n\n\t第二十届中国国际软件博览会\n\n\t2016中国软件和信息技术服务业发展高峰论坛\n\n\t2016云栖大会·深圳峰会\n\n\t天下女人国际论坛\n\n\t2016年CFO财务峰会\n\n\n10、国脉互联\n1）中标项目\n共计2项，包括徐汇区门户网站政务大厅政府服务事项梳理服务等，约中金额142万元。\n2）官网新闻\n共计发布13篇。\n3）出席会议\n\t国脉互联出席会议概览（8场）\n\n\t中国跨境电商50人论坛\n\n\t内蒙古\"互联网+政务\"创新趋势研讨会\n\n\t中国智慧城市发展与评估指标体系建设专家研讨会\n\n\t2016年广东（云浮）智慧城市与电子政务专题研讨会\n\n\t2016年吉林省政务云项目探讨会\n\n\t2016年北京市卫生计生系统网站培训会\n\n\t禅城区2016年信息化与创新发展培训班\n\n\t2016中国（青海）“互联网+政务”创新趋势全国巡回研讨会\n\n\n5、 改进措施\n1、 鉴于招投标在参考消息报中潜在的销售价值，自10月份起招投标更新信息调整为固定每周五提交。\n2、 调整招投标区域：重点关注包括北京、上海、浙江、深圳、成都、武汉等经济发达地区、长三角地区及珠三角地区。同时，加强关注该重点省级招投标网站的最新信息。\n3、 招投标的信息搜集重点调整为与公司密切相关的软件系统开发、信息资源整合等方面的业务。教科文行业不再罗列电子资源的招标与中标情况。\n4、 行业动态中减少医疗方面的资讯，改为健康方面的资讯。\n5、 增加竞争对手如上海上业、联图科技、创文科技等企业的动态，并重点关注竞争对手的最新产品和出席展会的新动态。";

		SummaryComputer sc = new SummaryComputer(200, true, null, content);

		TagContent tc = new TagContent("<begin>", "<end>");


		List<Keyword> list = new ArrayList<>() ;
		for (String s : kws) {
			list.add(new Keyword(s, s.length() * s.length() * 1000)) ;
		}

		System.out.println(list);



		String tagContent = tc.tagContent(sc.toSummary(list));

		System.out.println(tagContent);
	}

}
