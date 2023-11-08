//package com.edu.zhy.api.api.threadpool.util;
//
//
//import org.glassfish.jersey.client.ClientConfig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.integration.core.MessageProducer;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.MessageFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * This is the main entry point to the system.
// */
//public class Cat {
//    private static final Logger logger = LoggerFactory.getLogger(Cat.class.getName().replace("dianping", "youzan"));
//    private static Cat s_instance = new Cat();
//
//    private static volatile boolean s_init = false;
//
//    private MessageProducer m_producer;
//
//    private MessageManager m_manager;
//
//    private PlexusContainer m_container;
//
//    private static void checkAndInitialize() {
//        if (!s_init) {
//            synchronized (s_instance) {
//                if (!s_init) {
//                    initialize(new File(getCatHome(), "client.xml"));
//                    log("WARN", "Cat is lazy initialized!");
//                    s_init = true;
//                }
//            }
//        }
//    }
//
//    public static String createMessageId() {
//        return Cat.getProducer().createMessageId();
//    }
//
//    public static void destroy() {
//        s_instance.m_container.dispose();
//        s_instance = new Cat();
//    }
//
//    public static String getCatHome() {
//        String catHome = Properties.forString().fromEnv().fromSystem().getProperty("CAT_HOME", "/data/appdatas/cat");
//
//        return catHome;
//    }
//
//    public static String getCurrentMessageId() {
//        MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
//
//        if (tree != null) {
//            String messageId = tree.getMessageId();
//
//            if (messageId == null) {
//                messageId = Cat.createMessageId();
//                tree.setMessageId(messageId);
//            }
//            return messageId;
//        } else {
//            return null;
//        }
//    }
//
//    public static Cat getInstance() {
//        return s_instance;
//    }
//
//    public static MessageManager getManager() {
//        checkAndInitialize();
//
//        return s_instance.m_manager;
//    }
//
//    public static MessageProducer getProducer() {
//        checkAndInitialize();
//
//        return s_instance.m_producer;
//    }
//
//    // this should be called during application initialization time
//    public static void initialize(File configFile) {
//        PlexusContainer container = ContainerLoader.getDefaultContainer();
//
//        initialize(container, configFile);
//    }
//
//    public static void initialize(PlexusContainer container, File configFile) {
//        ModuleContext ctx = new DefaultModuleContext(container);
//        Module module = ctx.lookup(Module.class, CatClientModule.ID);
//
//        if (!module.isInitialized()) {
//            ModuleInitializer initializer = ctx.lookup(ModuleInitializer.class);
//
//            ctx.setAttribute("cat-client-config-file", configFile);
//            initializer.execute(ctx, module);
//        }
//    }
//
//    public static void initialize(String... servers) {
//        File configFile = null;
//
//        try {
//            configFile = File.createTempFile("cat-client", ".xml");
//            ClientConfig config = new ClientConfig().setMode("client");
//
//            for (String server : servers) {
//                config.addServer(new Server(server));
//            }
//
//            Files.forIO().writeTo(configFile, config.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        initialize(configFile);
//    }
//
//    public static void initialize(String appName, String[] servers) {
//        Map<String, Object> extConfig = new HashMap<>();
//        extConfig.put(Constant.APOLLO_ENABLE, true);
//        initialize(appName, servers, extConfig);
//    }
//
//    /**
//     *
//     * @param appName
//     * @param servers
//     * @param extConfig
//     */
//    public static void initialize(String appName, String[] servers, Map<String, Object> extConfig) {
//        File configFile = null;
//        try {
//            configFile = File.createTempFile("cat-client", ".xml");
//            ClientConfig config = new ClientConfig().setMode("client");
//            config.addDomain(new Domain(appName).setEnabled(true));
//            for (String server : servers) {
//                config.addServer(new Server(server));
//            }
//            Files.forIO().writeTo(configFile, config.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.setProperty("cat-client-tmp", configFile.getAbsolutePath());
//        initialize(configFile);
//        //启用Apollo的情况下,进行采样
//        if((boolean)extConfig.get(Constant.APOLLO_ENABLE)) {
//            Sample.initialize();
//        }
//        //初始化指标数据发送任务
//        if(extConfig.containsKey(Constant.METRICS_COLLECTOR)) {
//            Map<String, Object> metricCollector = (Map<String, Object>)extConfig.get(Constant.METRICS_COLLECTOR);
//            String[] hosts = (String[])metricCollector.get(Constant.HOSTS);
//            int port = (int)metricCollector.get(Constant.PORT);
//            DataSender.init(hosts, port);
//        }
//    }
//
//    public static boolean isInitialized() {
//        synchronized (s_instance) {
//            return s_instance.m_container != null;
//        }
//    }
//
//    static void log(String severity, String message) {
//        MessageFormat format = new MessageFormat("[{0,date,MM-dd HH:mm:ss.sss}] [{1}] [{2}] {3}");
//        System.out.println(format.format(new Object[] { new Date(), severity, "cat", message }));
//    }
//
//    public static void logError(String message, Throwable cause) {
//        Cat.getProducer().logError(message, cause);
//    }
//
//    public static void logError(Throwable cause) {
//        Cat.getProducer().logError(cause);
//    }
//
//    public static void logEvent(String type, String name) {
//        Cat.getProducer().logEvent(type, name);
//    }
//
//    public static void logEvent(String type, String name, String status, String nameValuePairs) {
//        Cat.getProducer().logEvent(type, name, status, nameValuePairs);
//    }
//
//    public static void logHeartbeat(String type, String name, String status, String nameValuePairs) {
//        Cat.getProducer().logHeartbeat(type, name, status, nameValuePairs);
//    }
//
//    public static void logMetric(String name, Object... keyValues) {
//        // TO REMOVE ME
//    }
//
//    /**
//     * Increase the counter specified by <code>name</code> by one.
//     *
//     * @param name
//     *           the name of the metric default count value is 1
//     */
//    public static void logMetricForCount(String name) {
//        logMetricInternal(name, "C", "1");
//    }
//
//    /**
//     * Increase the counter specified by <code>name</code> by one.
//     *
//     * @param name
//     *           the name of the metric
//     */
//    public static void logMetricForCount(String name, int quantity) {
//        logMetricInternal(name, "C", String.valueOf(quantity));
//    }
//
//    /**
//     * Increase the metric specified by <code>name</code> by <code>durationInMillis</code>.
//     *
//     * @param name
//     *           the name of the metric
//     * @param durationInMillis
//     *           duration in milli-second added to the metric
//     */
//    public static void logMetricForDuration(String name, long durationInMillis) {
//        logMetricInternal(name, "T", String.valueOf(durationInMillis));
//    }
//
//    /**
//     * Increase the sum specified by <code>name</code> by <code>value</code> only for one item.
//     *
//     * @param name
//     *           the name of the metric
//     * @param value
//     *           the value added to the metric
//     */
//    public static void logMetricForSum(String name, double value) {
//        logMetricInternal(name, "S", String.format("%.2f", value));
//    }
//
//    /**
//     * Increase the metric specified by <code>name</code> by <code>sum</code> for multiple items.
//     *
//     * @param name
//     *           the name of the metric
//     * @param sum
//     *           the sum value added to the metric
//     * @param quantity
//     *           the quantity to be accumulated
//     */
//    public static void logMetricForSum(String name, double sum, int quantity) {
//        logMetricInternal(name, "S,C", String.format("%s,%.2f", quantity, sum));
//    }
//
//    private static void logMetricInternal(String name, String status, String keyValuePairs) {
//        Cat.getProducer().logMetric(name, status, keyValuePairs);
//    }
//
//    public static Context createEntryConext(Context ctx) {
//        MessageTree tree 	= Cat.getManager().getThreadLocalMessageTree();
//
//        String rootId 		= Cat.createMessageId();
//        String parentId 	= "null";
//        String messageId	= Cat.createMessageId();
//
//        ctx.addProperty(Context.ROOT, rootId);
//        ctx.addProperty(Context.PARENT, parentId);
//        ctx.addProperty(Context.CHILD, messageId);
//
//        tree.setRootMessageId(rootId);
//        tree.setParentMessageId(parentId);
//        tree.setMessageId(messageId);
//
//        return ctx;
//    }
//
//    public static void logRemoteCallClient(Context ctx) {
//        MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
//        String messageId = tree.getMessageId();
//
//        if (messageId == null) {
//            messageId = Cat.createMessageId();
//            tree.setMessageId(messageId);
//        }
//
//        String childId = Cat.createMessageId();
//        Cat.logEvent(CatConstants.TYPE_REMOTE_CALL, "", Event.SUCCESS, childId);
//
//        String rootId = tree.getRootMessageId();
//
//        if (rootId == null) {
//            rootId = messageId;
//        }
//        // ctx是传递到dubbo服务端用的
//        ctx.addProperty(Context.ROOT, rootId);
//        ctx.addProperty(Context.PARENT, messageId);
//        ctx.addProperty(Context.CHILD, childId);
//
//        // tree是本节点上报cat服务器用的, 入口应用rid=pid=mid
//        if(tree.getRootMessageId()==null){
//            tree.setRootMessageId(rootId);
//        }
//        if(tree.getParentMessageId()==null){
//            tree.setParentMessageId(messageId);
//        }
//        if(tree.getMessageId()==null){
//            tree.setMessageId(messageId);
//        }
//        tree.setChildMessageId(childId);
//    }
//
//    public static void logRemoteCallServer(Context ctx) {
//        MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
//        // ctx->tree是dubbo接受consumer传来的上下文
//        String rootId = ctx.getProperty(Context.ROOT);
//        String parentId = ctx.getProperty(Context.PARENT);
//        String messageId = ctx.getProperty(Context.CHILD);
//
//        if (messageId != null) {
//            tree.setMessageId(messageId);
//        }
//        if (parentId != null) {
//            tree.setParentMessageId(parentId);
//        }
//        if (rootId != null) {
//            tree.setRootMessageId(rootId);
//        }
//    }
//
//    public static void logTrace(String type, String name) {
//        Cat.getProducer().logTrace(type, name);
//    }
//
//    public static void logTrace(String type, String name, String status, String nameValuePairs) {
//        Cat.getProducer().logTrace(type, name, status, nameValuePairs);
//    }
//
//    public static <T> T lookup(Class<T> role) throws ComponentLookupException {
//        return lookup(role, null);
//    }
//
//    public static <T> T lookup(Class<T> role, String hint) throws ComponentLookupException {
//        return s_instance.m_container.lookup(role, hint);
//    }
//
//    public static Event newEvent(String type, String name) {
//        return Cat.getProducer().newEvent(type, name);
//    }
//
//    public static ForkedTransaction newForkedTransaction(String type, String name) {
//        return Cat.getProducer().newForkedTransaction(type, name);
//    }
//
//    public static Heartbeat newHeartbeat(String type, String name) {
//        return Cat.getProducer().newHeartbeat(type, name);
//    }
//
//    public static TaggedTransaction newTaggedTransaction(String type, String name, String tag) {
//        return Cat.getProducer().newTaggedTransaction(type, name, tag);
//    }
//
//    public static Trace newTrace(String type, String name) {
//        return Cat.getProducer().newTrace(type, name);
//    }
//
//    @Deprecated
//    public static Transaction customerLog(String customerKey) {
//        return null;
//    }
//
//    public static Transaction newTransaction(String type, String name) {
//        return Cat.getProducer().newTransaction(type, name);
//    }
//
//    // this should be called when a thread ends to clean some thread local data
//    public static void reset() {
//        // remove me
//    }
//
//    // this should be called when a thread starts to create some thread local data
//    public static void setup(String sessionToken) {
//        Cat.getManager().setup();
//    }
//
//    /**
//     *  调用该方法会让客户端数据一定上报，否则的话会走客户端采样逻辑。关于采样的
//     */
//
//    public static void mustReport(){
//        MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
//        tree.setSample(false);
//    }
//    private Cat() {
//    }
//
//    void setContainer(PlexusContainer container) {
//        try {
//            m_container = container;
//            m_manager = container.lookup(MessageManager.class);
//            m_producer = container.lookup(MessageProducer.class);
//        } catch (ComponentLookupException e) {
//            throw new RuntimeException("Unable to get instance of MessageManager, "
//                    + "please make sure the environment was setup correctly!", e);
//        }
//    }
//
//    public static interface Context {
//
//        public final String ROOT = "_catRootMessageId";
//
//        public final String PARENT = "_catParentMessageId";
//
//        public final String CHILD = "_catChildMessageId";
//
//        public void addProperty(String key, String value);
//
//        public String getProperty(String key);
//    }
//
//
//
//}
//
