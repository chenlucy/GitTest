package com.tocean.entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.*;
import org.hibernate.search.annotations.Field;
/**
 * Created by Administrator on 2017/9/9.
 */
@Entity
@Data
@Table(name="item_product")
public class Product extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String HITS_CACHE_NAME = "productHits";
    public static final int HITS_CACHE_INTERVAL = 600000;
    public static final int ATTRIBUTE_VALUE_PROPERTY_COUNT = 20;
    public static final String ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX = "attributeValue";
    public static final String FULL_NAME_SPECIFICATION_PREFIX = "[";
    public static final String FULL_NAME_SPECIFICATION_SUFFIX = "]";
    public static final String FULL_NAME_SPECIFICATION_SEPARATOR = " ";
    private static String staticPath;
    private static String staticMobilePath;

    @JsonProperty
    @Id
    @Column(name = "P_UUID", unique = true, nullable = false, length = 44)
    private String PUuid; //产品uuid

    @JsonProperty
    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
    @Pattern(regexp = "^[0-9a-zA-Z_-]+$")
    @Length(max = 200)
    @Column(name = "P_SN", nullable = false, unique = true)
    private String PSn;		//产品编号
//
//    //海关商品HS编码
//    @JsonProperty
//    @Length(max = 200)
//    @Column(name = "P_HGSN", nullable = false, unique = true)
//    private String PHgSn;	//海关商品HS编码
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
//    @NotEmpty
//    @Length(max = 200)
//    @Column(name = "P_NAME", nullable = false)
//    private String PName; //产品名称
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
//    @Length(max = 200)
//    @Column(name = "P_WXINTRODUCTION", nullable = false)
//    private String PWxIntroduction; //产品简单介绍，用在微信首页展示
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
//    @Column(name = "P_FULLNAME", nullable = false)
//    private String PFullName; //产品全称
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
////    @FieldBridge(impl = hwfw.cweb.baseobject.BigDecimalNumericFieldBridge.class)
//    @NotNull
//    @Min(0L)
//    @Digits(integer = 12, fraction = 3)
//    @Column(name = "P_PRICE", nullable = false, precision = 21, scale = 6)
//    private BigDecimal PPrice; //销售价格
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
////    @FieldBridge(impl = hwfw.cweb.baseobject.BigDecimalNumericFieldBridge.class)
//    @NotNull
//    @Min(0L)
//    @Digits(integer = 12, fraction = 3)
//    @Column(name = "P_ADDBUYPRICE", nullable = false, precision = 21, scale = 6)
//    private BigDecimal PAddBuyPrice; //用户在购物车上面加价购买的价格
//
//    @Min(0L)
//    @Digits(integer = 12, fraction = 3)
//    @Column(name = "P_COST", precision = 21, scale = 6)
//    private BigDecimal PCost; //成本价格
//
////    @Field(store = Store.YES, index = Index.NO)
//    @Min(0L)
//    @Digits(integer = 12, fraction = 3)
//    @Column(name = "P_MARKETPRICE", precision = 21, scale = 6, nullable = false)
//    private BigDecimal PMarketPrice; //市场价格
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.NO)
//    @Length(max = 255)
//    @Column(name = "P_IMAGE")
//    private String PImage; //商品的略缩图
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.NO)
//    @Length(max = 255)
//    @Column(name = "P_ADIMAGE")
//    private String PAdImage; //商品首页导航620*310广告图
//
//    @Column(name = "P_MOBILEIMAGE")
//    private String PMobileImage; //280*160手机微信主图广告图
//
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.NO)
//    @Length(max = 255)
//    @Column(name = "P_UNIT")
//    private String PUnit;	//商品计量单位
//
////    @Field(store = Store.YES, index = Index.NO)
//    @Min(0L)
//    @Column(name = "P_WEIGHT", precision = 15)
//    private Double PWeight;	//商品重量
//
////    @Field(store = Store.YES, index = Index.NO)
//    @Min(0L)
//    @Column(name = "P_STOCK", precision = 15)
//    private Double PStock; //库存
//
////    @Field(store = Store.YES, index = Index.NO)
//    @Column(name = "P_ALLOCATEDSTOCK", precision = 15, nullable = false)
//    private Double PAllOcatedStock; //预分配库存
//
//    @Length(max = 255)
//    @Column(name = "P_STOCKMEMO")
//    private String PStockMemo; //库存备注
//
////    @Field(store = Store.YES, index = Index.NO)
//    @Min(0L)
//    @Column(name = "P_POINT", precision = 15, nullable = false)
//    private Double PPoint;	//赠送积分
//
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
//    @NotNull
//    @Column(name = "P_ISMARKETABLE", precision = 4, nullable = false)
//    private Double PIsMarketable; //是否上架
//
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
//    @NotNull
//    @Column(name = "P_ISLIST", precision = 4, nullable = false)
//    private Double PIsList; //是否列出
//
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
//    @NotNull
//    @Column(name = "P_ISTOP", precision = 4, nullable = false)
//    private Double PIsTop;	//是否置顶
//
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
//    @JsonProperty
//    @NotNull
//    @Column(name = "P_ISGIFT", precision = 4, nullable = false)
//    private Double PIsGift; //是否为赠品
//
//    @Column(name = "P_ISREVIEW", precision = 4, nullable = false)
//    private Double PIsReview; //是否可以评价
////
////    @Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
////    @Lob
//    @Column(name = "P_INTRODUCTION")
//    private String PMemo; //备注
//
////    @Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
//    @Length(max = 200)
//    @Column(name = "P_KEYWORD")
//    private String PKeyword; //关键词
//
//    @Length(max = 255)
//    @Column(name = "P_SEOTITLE")
//    private String PSeoTitle; //页面标题:
//    @Length(max = 255)
//    @Column(name = "P_SEOKEYWORDS")
//    private String PSeoKeywords; //页面关键词:
//
//    @Column(name = "P_SEODESCRIPTION")
//    private String PSeoDescription; //页面描述:
//    @JsonProperty
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
////    @NumericField
//    @Column(name = "P_SCORE", precision = 21, scale = 6, nullable = false)
//    private String PIntroduction; //商品介绍
//    @Column(name = "P_TOTALSCORE", precision = 15, nullable = false)
//    private String PMobileIntroduction; //手机商品介绍
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT", precision = 15, nullable = false)
//    private String PLastComment; //商品最后一次评价,为了加快前端访问的速度,存在这里
//
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT1", precision = 15, nullable = false)
//    private Double PScore;		 	//用户评价分
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT2", precision = 15, nullable = false)
//    private Double PTotalScore;  	//用户总评价分
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT3", precision = 15, nullable = false)
//    private Double PScoreCount;		//用户评价次数
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT4", precision = 15, nullable = false)
//    private Double PScoreCount1;		//用户1分评价次数
//
//    private Double PScoreCount2;		//用户2分评价次数
//
//    private Double PScoreCount3;		//用户3分评价次数
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT4", precision = 15, nullable = false)
//    private Double PScoreCount4;		//用户4分评价次数
////    @Field(store = Store.YES, index = Index.UN_TOKENIZED)
//    @Column(name = "P_SCORECOUNT5", precision = 15, nullable = false)
//    private Double PScoreCount5;		//用户5分评价次数
//
//    private Double PHits;			//用户点击次数,用户的浏览数
//
//    private Double PBaseHits;		//基础浏览数
//
//    private Boolean PIsHot;			//是否是热销产品
//
//    private Double POrder;			//推荐排序,跟其它的排序区分开
//
//    private Double PWeekHits;		//
//
//    private Double PMonthHits;		//
//
//    private Double PSales;	//产品销量
//
//    private Double PWeekSales;		//
//
//    private Double PMonthSales;		//
//
//    private Date PWeekHitsDate;
//
//    private Date PMonthHitsDate;
//
//    private Date PWeekSalesDate;
//
//    private Date PMonthSalesDate;
//
//    private Double PCountReview;
//
//    private Double PCountCollect;	//这个商品总共收藏数据
//
//    private Double PCountShare;		//这个商品总共分享的数量
//
//    private String PAttributeValue0;
//
//    private String PAttributeValue1;
//
//    private String PAttributeValue2;
//
//    private String PAttributeValue3;
//
//    private String PAttributeValue4;
//
//    private String PAttributeValue5;
//
//    private String PAttributeValue6;
//
//    private String PAttributeValue7;
//
//    private String PAttributeValue8;
//
//    private String PAttributeValue9;
//
//    private String PAttributeValue10;
//
//    private String PAttributeValue11;
//
//    private String PAttributeValue12;
//
//    private String PAttributeValue13;
//
//    private String PAttributeValue14;
//
//    private String PAttributeValue15;
//
//    private String PAttributeValue16;
//
//    private String PAttributeValue17;
//
//    private String PAttributeValue18;
//
//    private String PAttributeValue19;
//
//    private String POtherLink1;
//
//    private String POtherLink2;

//    private Goods goods;
//
//    private Category category;
//
//    private SysCategory sysCategory;
//
//    private Ppatax ppatax;  //海关税编码
//
//    private Brand brand;

//    private String PErpCode;  //商品ERP统一编码
//
//    private Boolean PIsFinishFax; //是否完税产品0非完税（跨境默认是非完税），1完税（普通默认是完税） (默认值setting配置值)
//
//    //分销佣金-----------------------------------------------------------
//    //以下每一个二个
//    private Boolean PIsGetSubTraderMoney;	//*如果没有下级分销商，上级分销商领取下级分销商佣金：1是  0否(默认是) (默认值setting配置值)
//    private Boolean PIsNoTraderMoney;		//*分销商返佣：0开启 1 关闭 关闭后，将不给分销商返佣 (默认值setting配置值)
//    private BigDecimal	PTraderFirstMoney;		//直属上级能拿到的佣金 元   ： 金额和比例都为0.00或空表示采用分销商等级或系统设置的提成比例计算佣金
//    private Double	PTraderFirstPea;		//直属上级能拿到的佣金  比例% ： 金额和比例都为0.00或空表示采用分销商等级或系统设置的提成比例计算佣金
//
//    private BigDecimal	PTraderSecondMoney;		//二级上级能拿到的佣金 元   ： 金额和比例都为0.00或空表示采用分销商等级或系统设置的提成比例计算佣金
//    private Double		PTraderSecondPea;	//直属上级能拿到的佣金  比例% ： 金额和比例都为0.00或空表示采用分销商等级或系统设置的提成比例计算佣金
//
//    private BigDecimal		PTraderThreeMoney;	//三级上级能拿到的佣金元 ： 金额和比例都为0.00或空表示采用分销商等级或系统设置的提成比例计算佣金
//    private Double PTraderThreePea;	//三级上级能拿到的佣金 比例%
//
//    private Boolean PIsGetSubAgentMoney;	//*如果没有下级代理商，上级代理商领取下级代理商佣金：1是  0否(默认是) (默认值setting配置值)
//    private Boolean PIsNoAgentMoney;	//代理商返佣：0开启 1 关闭 关闭后，将不给代理商返佣。 (默认值setting配置值)
//
//    private BigDecimal	PAgentFirstMoney;	//一级代理商能拿到的佣金：0.00 元  或    0.000 % 金额和比例都为0.00或空表示采用代理商的提成比例计算佣金
//    private Double PAgentFirstPea; //一级代理商能拿到的佣金比例
//
//    private BigDecimal	PAgentSecondMoney;	//二级代理商能拿到的佣金：0.00 元  或    0.000 % 金额和比例都为0.00或空表示采用代理商的提成比例计算佣金
//    private Double PAgentSecondPea;//二级代理商能拿到的佣金比例
//
//    private BigDecimal	PAgentThreeMoney;	//三级代理商能拿到的佣金：0.00 元  或    0.000 % 金额和比例都为0.00或空表示采用代理商的提成比例计算佣金
//    private Double	PAgentThreePea;//三级代理商能拿到的佣金比例





//    //物流及其它-------------------------
//    private Boolean PIsNoLogistics; //免物流：1是  0否	会员购买免物流商品时，不需要填写收货地址。(默认值setting配置值)
//    private Boolean PIsShowStock; //库存显示：1是  0否  默认否 (默认值setting配置值)
//    private Double	PFirstPoint;//直属上级能拿到积分：
//    private Double	PSecondPoint;//二级上级能拿到积分：
//    private Double	PThreePoint;//三级上级能拿到积分：
//    private Double	PBaseSales;//基础销量：	//在前端显示的实际销售量，=基础销量，加后面的销量
//    private Double  PPraiseNum;//赞数：	//实际顶数=基础点赞数+赞数
//    private Double  PBasePraiseNum;//基础点赞数：	//实际顶数=基础点赞数+赞数
//
//
//    private Double	PVolume;//体积：	0.0000	 m³(最多四位小数)



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_product_tag", joinColumns = { @JoinColumn(name = "P_UUID") }, inverseJoinColumns = { @JoinColumn(name = "T_UUID") })
    @OrderBy("orders asc")
    private Set<Tag> tags = new HashSet<Tag>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_product_specification", joinColumns = { @JoinColumn(name = "P_UUID") }, inverseJoinColumns = { @JoinColumn(name = "S_UUID") })
    @OrderBy("orders asc")
    private Set<Specification> specifications = new HashSet<Specification>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_product_specification_dtls", joinColumns = { @JoinColumn(name = "P_UUID") }, inverseJoinColumns = { @JoinColumn(name = "SD_UUID") })
    @OrderBy("orders asc")
    private Set<SpecificationDtl> specificationDtls = new HashSet<SpecificationDtl>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "item_product_parameter_dtls", joinColumns = { @JoinColumn(name = "P_UUID") })
    @MapKeyJoinColumn(name = "PD_UUID")
    @Column(name = "VAL")
    private Map<ParameterDtl, String> parameterDtls = new HashMap<ParameterDtl, String>();

    @JsonProperty
    @Valid
    @ElementCollection
    @CollectionTable(name = "item_product_productImage", joinColumns = @JoinColumn(name = "P_UUID"))
    private List<ProductImage> productImages = new ArrayList<ProductImage>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { javax.persistence.CascadeType.REMOVE })
    private Set<Review> reviews = new HashSet<Review>();

//    private Set<Consultation> consultations = new HashSet<Consultation>();
//
//    private Set<Member> collectMembers = new HashSet<Member>();
//
//    private Set<Promotion> promotions = new HashSet<Promotion>();
//
//    private Set<CartItem> cartItems = new HashSet<CartItem>();
//
//    private Set<OrderItem> orderItems = new HashSet<OrderItem>();
//
//    private Set<GiftItem> giftItems = new HashSet<GiftItem>();
//
//    private Set<Notify> notifys = new HashSet<Notify>();




//    private Map<MemberRank, BigDecimal> memberPrice = new HashMap<MemberRank, BigDecimal>();

    /**
     * topDesc 置顶
     * priceAsc 价格升
     * priceDesc 价格降
     * salesDesc 销量升
     * scoreDesc 积分
     * dateDesc 日期
     * */
    public enum OrderType {
        topDesc, priceAsc, priceDesc, salesDesc, scoreDesc, dateDesc;
    }



//    static {
//        try {
//            File _file = new File(SettingUtils.get().getTemplatePath());//
//            Document _document = new SAXReader().read(_file);
//            Element _elementMobile = (Element) _document.selectSingleNode(SettingUtils.NODES_TEMPLATE+ "[@id='wxproductContent']");
//            staticMobilePath= _elementMobile.attributeValue("staticPath");
//            Element _element = (Element) _document.selectSingleNode(SettingUtils.NODES_TEMPLATE+ "[@id='productContent']");
//            staticPath = _element.attributeValue("staticPath");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
