import junit.framework.TestCase;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//nextInt is normally exclusive of the top value,
//so add 1 to make it inclusive


public class ClassUrlValidatorTests extends TestCase {
public int numTests = 5;
public int numValidSchemes = 10;
public int numInvalidSchemes = 10;
public int numValidDomains = 10;
public int numValidAuthorities = 10;
public int numInvalidAuthorities = 10;
public int timesToRunSuiteInMain = 100;

private String validSchemes[] = {"http://",
    "ftp://",
    "h3t://", /*"aaa://","aaas://","about://","acap://","acct://","acr://","adiumxtra://","afp://","afs://","aim://","appdata://","apt://","attachment://","aw://","barion://",
"beshare://","bitcoin://","blob://","bolo://","browserext://","callto://","cap://","chrome://","chrome-extension://","cid://","coap://","coaps://","com-eventbrite-attendee://","content://",
"crid://","cvs://","data://","dav://","dict://","dis://","dlna-playcontainer://","dlna-playsingle://","dns://","dntp://","dtn://","dvb://","ed2k://","example://",
".facetime://","fax://","feed://","feedready://","file://","FILESYSTEM://","finger://","fish://","ftp://","geo://","gg://","git://","gizmoproject://","go://","gopher://","graph://",
".gtalk://","h323://","ham://","hcp://","http://","https://","hxxp://","hxxps://","hydrazone://","iax://","icap://","icon://","im://","imap://","info://","iotdisco://","ipn://","ipp://","ipps://","irc://","irc6://","ircs://","iris://","iris.beep://","iris.lwz://","iris.xpc://","iris.xpcs://","isostore://","itms://","jabber://","jar://","jms://","keyparc://","lastfm://","ldap://","ldaps://",
".lvlt://","magnet://","mailserver://","mailto://","maps://","market://","message://","mid://","mms://","modem://","mongodb://","moz://","ms-access://","ms-browser-extension://",
".ms-drive-to://","ms-enrollment://","ms-excel://","ms-gamebarservices://","ms-getoffice://","ms-help://","ms-infopath://","ms-media-stream-id://","ms-ofFiceapp://","ms-People://","ms-project://","ms-powerpoint://","ms-publisher://","ms-search-repair://","ms-secondary-screen-controller://","ms-secondary-screen-setup://","ms-settings://","ms-settings-airplanemode://","ms-settings-bluetooth://",
".ms-settings-camera://","ms-settings-cellular://","ms-settings-cloudstorage://","ms-settings-connectabledevices://","ms-settings-displays-topology://","ms-settings-emailandaccounts://",
".ms-settings-language://","ms-settings-location://","ms-settings-lock://","ms-settings-nfctransactions://","ms-settings-notifications://","ms-settings-power://","ms-settings-privacy://",
".ms-settings-proximity://","ms-settings-screenrotation://","ms-settings-wifi://","ms-settings-workplace://","ms-spd://","ms-sttoverlay://","ms-transit-to://","ms-virtualtouchpad://",
".ms-visio://","ms-walk-to://","ms-whiteboard://","ms-whiteboard-cmd://","ms-word://","msnim://","msrp://","msrps://","mtqp://","mumble://","mupdate://","mvn://","news://",
".nfs://","ni://","nih://","nntp://","notes://","ocf://","oid://","onenote://","onenote-cmd://","opaquelocktoken://","pack://","palm://","paparazzi://","pkcs11://","platform://",
".pop://","pres://","prospero://","proxy://","pwid://","psyc://","qb://","query://","redis://","rediss://","reload://","res://","resource://","rmi://","rsync://","rtmfp://",
".rtmp://","rtsp://","rtsps://","rtspu://","secondlife://","service://","session://","sftp://","sgn://","shttp://","sieve://","sip://","sips://","skype://","smb://","sms://","smtp://",
".snews://","snmp://","soap.beep://","soap.beeps://","soldat://","spotify://","ssh://","steam://","stun://","stuns://","submit://","svn://","tag://","teamspeak://","tel://","teliaeid://",
".telnet://","tftp://","things://","thismessage://","tip://","tn3270://","tool://","turn://","turns://","tv://","udp://","unreal://","urn://","utSB_Length4://","v-event://","vemmi://",
".ventrilo://","videotex://","vnc://","view-source://","wais://","webcal://","wpid://","ws://","wss://","wtai://","wyciwyg://","xcon://","xcon-userid://","xfire://","xmlrpc.beep://",
".xmlrpc.beeps://","xmpp://","xri://","ymsgr://","z39.50://","z39.50r://","z39.50s"*/
};

private String invalidSchemes[] = {"123://", "",  " 07t://", "mob://", "s5u://", "a79://", "wmt://", "l8c://", "8s7://", "tfx://", "8u2://", "sww://", "e35://", "70t://", "h9s://", "6ho://", "fu1://", "gax://", "vi8://", "zno://", 
"7b8://", "76r://", "vxq2://", "zmt8://", "jcam://", "p131://", "g205://", "qhjg://", "iiyg://", "6y#$b7://", "5e44://", "u0ik://", "h77^&l://", "u5jx://",  "1edl://", "vqzs://", "zds8://", "9ggl://", "iemb://", "b97m://", "bu3s://", "yucy://",
".ns6ji://", "02nwx://", "ce39m://", "nx86g://", "f90fg://", "4nb29://", "e3s77://", "m1bhb://", "hzogh://", "dgbxy://", "bm1re://", "uusft://", "yypax://", "bsos2://", "qv4h6://", "il7nw://", "dbv2d://", "vkji3://", "luba9://", "e5p1i://", 
".3t4s6b://", "c8ulgt://", "ufzw0x://", "# k70ypw://", "zsnppf://", "tzpxi2://", "rxumqv://", "4hxe3[sj://", "sqe9wn://", "49znxw://", "yvtq2a://", "tjf4gl://", "x28w29://", "ky2aca://", "vvwtn9://", "0w69zm://", "c4uwmr://", "5jmgut://", "z1gdcw://", "=+3dim27://",
".1oevhjh://", "x4ff5mg://", "635kxtf://", "20rm0u3://", "ck9jknx://", "b32zegj://", "4e:j13gv://", "n2fkix3://", "uswhc32://", "qo7y3cg://", "9tbzg0h://", "m32fkuy://", "4wewdch://", "6kadwyc://", "aqcbqy9://", "jgczjl9://", "jesq-9zn://",
"sqihcdj://", "knzgm26://", "3ph90kd://", "aaa:/","aaas:/","about:/","acap:/","acct:/","acr:/","adiumxtra:/","afp:/","afs:/","aim:/","appdata:/","apt:/","attachment:/","aw:/","barion:/","beshare:/","bitcoin:/","blob:/","bolo:/","browserext:/","callto:/","cap:/",
".chrome:/","chrome-extension:/","cid:/","coap:/","coaps:/","com-eventbrite-attendee:","content:","crid:","cvs:","data:","dav:","dict:","dis:","dlna-playcontainer:","dlna-playsingle:","dns:","dntp:","dtn:","dvb:","ed2k:","example:",
".facetime:","fax:","feed:","feedready:","file:","filesystem:","finger:","fish:","ftp:","geo:","gg:","git:","gizmoproject:","go:","gopher:","graph:","gtalk:","h323:","ham:","hcp:","http:","https:","hxxp:","hxxps:","hydrazone:","iax:",
".icap:","icon:","im:","imap:","info:","iotdisco:","ipn:","ipp:","ipps:","irc:","irc6:","ircs:","iris:","iris.beep:","iris.lwz:","iris.xpc:","iris.xpcs:","isostore:","itms:","jabber:","jar:","jms:","keyparc:","lastfm:","ldap:","ldaps:",
".lvlt:","magnet:","mailserver:","mailto:","maps:","market:","message:","mid:","mms:","modem:","mongodb:","moz:","ms-access:","ms-browser-extension:","ms-drive-to:","ms-enrollment:","ms-excel:","ms-gamebarservices:","ms-getoffice:","ms-help:",
".ms-infopath:/","ms-media-stream-id:/","ms-officeapp:/","ms-people:/","ms-project:/","ms-powerpoint:/","ms-publisher:/","ms-search-repair:/","ms-secondary-screen-controller:/","ms-secondary-screen-setup:/","ms-settings:/","ms-settings-airplanemode:/","ms-settings-bluetooth:/",
".ms-settings-camera:/","ms-settings-cellular:/","ms-settings-cloudstorage:/","ms-settings-connectabledevices:/","ms-settings-displays-topology:/","ms-settings-emailandaccounts:/","ms-settings-language:/","ms-settings-location:/","ms-settings-lock:/",
".ms-settings-nfctransactions:/","ms-settings-notifications:/","ms-settings-power:/","ms-settings-privacy:/","ms-settings-proximity:/","ms-settings-screenrotation:/","ms-settings-wifi:/","ms-settings-workplace:/",
".ms-spd:/","ms-sttoverlay:/","ms-transit-to:/","ms-virtualtouchpad:/","ms-visio:/","ms-walk-to:/","ms-whiteboard:/","ms-whiteboard-cmd:/","ms-word:/","msnim:/","msrp:/","msrps:/","mtqp:/","mumble:/","mupdate:/","mvn:/","news:/",
".nfs:/","ni:/","nih:/","nntp:/","notes:/","ocf:/","oid:/","onenote:/","onenote-cmd:/","opaquelocktoken:/","pack:/","palm:/","papa@/razzi:/","pkcs11:/","platform:/","pop:/","pres:/","prospero:/","proxy:/","pwid:/","psyc:/","qb:/","query:/",
".redis:/","rediss:/","reload:/","res:/","resource:/","rmi:/","rsync:/","rtmfp:/","rtmp:/","rtsp:/","rtsps:/","rtspu:/","secondlife:/","service:/","session:/","sftp:/","sgn:/","shttp:/","sieve:/","sip:/","sips:/",
".skype:/","smb:/","sms:/","smtp:/","snews:/","snmp:/","soap.beep:/","soap.beeps:/","soldat:/","spotify:/","ssh:/","steam:/","stun:/","stuns:/","submit:/","svn:/","tag:/","teamspeak:/","tel:/","teliaeid:/","telnet:/","tftp:/",
".things:/","thismessage:/","tip:/","tn3270:/","tool:/","turn:/","turns:/","tv:/","udp:/","unreal:/","urn:/","ut2004:/","v-event:/","vemmi:/","ventrilo:/","videotex:/","vnc:/","view-source:/","wais:/","webcal:/","wpid:/",
".ws:/","wss:/","wtai:/","wyciwyg:/","xcon:/","xcon-userid:/","xfire:/","xmlrpc.beep:/","xmlrpc.beeps:/","xmpp:/","xri:/","ymsgr:/","z39.50:/","z39.50r:/","z39.50s:/", "://", "=y=re://","ey?>8://","#GyKL://","Wah$n://","tUCQC://","F#%rk://",
".ug?3k://","lMD.o://","Lp8rY://","Nbuot://","Vo>qz://","Fe64R://","VCm[^://","Mrb&X://","-bpJP://","YEVI2://","f$!df://","ms1fy://","&1=}:://","d>^G>://","I}RQd://","1yK[z://","wAz}T://","?{3JH://","n}nd0://","Hp<r}://","_8SDh://","[Ot<c://","x<K)S://","W?02B://",
".Ls0fa://","P52(Q://","Mg&e>://","PM4GS://","!(nbR://","]{:Dd://","3an0f://","HeA-F://","jEz55://","_LAvg://",
};

private String validTopLevelDomains[] = {".cc", ".com", ".au", ".ac", ".ad", ".ae", ".af", ".ag", ".ai", ".al", ".am", ".an", ".ao", ".aq", ".ar", ".as", ".at", ".au", ".aw", ".ax", ".az", ".ba", ".bb", ".bd", ".be", ".bf", ".bg", ".bh", ".bi", ".bj", ".bm", ".bn", ".bo", ".br", ".bs", ".bt", ".bv", ".bw", ".by", ".bz", ".ca", ".cc", ".cd", ".cf", ".cg", ".ch", ".ci", ".ck", ".cl", ".cm", ".cn", ".co", ".cr", ".cs", ".cu", ".cv", ".cx", ".cy", ".cz", ".dd", ".de", ".dj", ".dk", ".dm", ".do", ".dz", ".ec", ".ee", ".eg", ".eh", ".er", ".es", ".et", ".eu", ".fi", ".fj", ".fk", ".fm", ".fo", ".fr", ".ga", ".gb", ".gd", ".ge", ".gf", ".gg", ".gh", ".gi", ".gl", ".gm", ".gn", ".gp", ".gq", ".gr", ".gs", ".gt", ".gu", ".gw", ".gy", ".hk", ".hm", ".hn", ".hr", ".ht", ".hu", ".id", ".ie", ".il", ".im", ".in", ".io", ".iq", ".ir", ".is", ".it", ".je", ".jm", ".jo", ".jp", ".ke", ".kg", ".kh", ".ki", ".km", ".kn", ".kp", ".kr", ".kw", ".ky", ".kz", ".la", ".lb", ".lc", ".li", ".lk", ".lr", ".ls", ".lt", ".lu", ".lv", ".ly", ".ma", ".mc", ".md", ".me", ".mg", ".mh", ".mk", ".ml", ".mm", ".mn", ".mo", ".mp", ".mq", ".mr", ".ms", ".mt", ".mu", ".mv", ".mw", ".mx", ".my", ".mz", ".na", ".nc", ".ne", ".nf", ".ng", ".ni", ".nl", ".no", ".np", ".nr", ".nu", ".nz", ".om", ".pa", ".pe", ".pf", ".pg", ".ph", ".pk", ".pl", ".pm", ".pn", ".pr", ".ps", ".pt", ".pw", ".py", ".qa", ".re", ".ro", ".rs", ".ru", ".rw", ".sa", ".sb", ".sc", ".sd", ".se", ".sg", ".sh", ".si", ".sj", ".sk", ".sl", ".sm", ".sn", ".so", ".sr", ".st", ".su", ".sv", ".sy", ".sz", ".tc", ".td", ".tf", ".tg", ".th", ".tj", ".tk", ".tl", ".tm", ".tn", ".to", ".tp", ".tr", ".tt", ".tv", ".tw", ".tz", ".ua", ".ug", ".uk", ".us", ".uy", ".uz", ".va", ".vc", ".ve", ".vg", ".vi", ".vn", ".vu", ".wf", ".ws", ".ye", ".yt", ".za", ".zm", ".zw"/*
"..aaa",".aarp",".abarth",".abb",".abbott",".abbvie",".abc",".able",".abogado",".abudhabi",".ac",".academy",".accenture",".accountant",".accountants",".aco",".active",".actor",".ad",".adac",".ads",".adult",".ae",".aeg",".aero",".aetna",".af",".afamilycompany",".afl",".africa",".ag",".agakhan",".agency",".ai",".aig",".aigo",".airbus",".airforce",".airtel",".akdn",".al",".alfaromeo",".alibaba",".alipay",".allfinanz",".allstate",".ally",".alsace",".alstom",".am",".americanexpress",".americanfamily",".amex",".amfam",".amica",".amsterdam",".an",".analytics",".android",".anquan",".anz",".ao",".aol",".apartments",".app",".apple",".aq",".aquarelle",".ar",".arab",".aramco",".archi",".army",".arpa",".art",".arte",".as",".asda",".asia",".associates",".at",".athleta",".attorney",".au",".auction",".audi",".audible",".audio",".auspost",".author",".auto",".autos",".avianca",".aw",".aws",".ax",".axa",".az",".azure",".ba",".baby",".baidu",".banamex",".bananarepublic",".band",".bank",".bar",".barcelona",".barclaycard",".barclays",".barefoot",".bargains",".baseball",".basketball",".bauhaus",".bayern",".bb",".bbc",".bbt",".bbva",".bcg",".bcn",".bd",".be",".beats",".beauty",".beer",".bentley",".berlin",".best",".bestbuy",".bet",".bf",".bg",".bh",".bharti",".bi",".bible",".bid",".bike",".bing",".bingo",".bio",".biz",".bj",".bl",".black",".blackfriday",".blanco",".blockbuster",".blog",".bloomberg",".blue",".bm",".bms",".bmw",".bn",".bnl",".bnpparibas",".bo",".boats",".boehringer",".bofa",".bom",".bond",".boo",".book",".booking",".boots",".bosch",".bostik",".boston",".bot",".boutique",".box",".bq",".br",".bradesco",".bridgestone",".broadway",".broker",".brother",".brussels",".bs",".bt",".budapest",".bugatti",".build",".builders",".business",".buy",".buzz",".bv",".bw",".by",".bz",".bzh",".ca",".cab",".cafe",".cal",".call",".calvinklein",".cam",".camera",".camp",".cancerresearch",".canon",".capetown",".capital",".capitalone",".car",".caravan",".cards",".care",".career",".careers",".cars",".cartier",".casa",".case",".caseih",".cash",".casino",".cat",".catering",".catholic",".cba",".cbn",".cbre",".cbs",".cc",".cd",".ceb",".center",".ceo",".cern",".cf",".cfa",".cfd",".cg",".ch",".chanel",".channel",".chase",".chat",".cheap",".chintai",".chloe",".christmas",".chrome",".chrysler",".church",".ci",".cipriani",".circle",".cisco",".citadel",".citi",".citic",".city",".cityeats",".ck",".cl",".claims",".cleaning",".click",".clinic",".clinique",".clothing",".cloud",".club",".clubmed",".cm",".cn",".co",".coach",".codes",".coffee",".college",".cologne",".com",".comcast",".commbank",".community",".company",".compare",".computer",".comsec",".condos",".construction",".consulting",".contact",".contractors",".cooking",".cookingchannel",".cool",".coop",".corsica",".country",".coupon",".coupons",".courses",".cr",".credit",".creditcard",".creditunion",".cricket",".crown",".crs",".cruise",".cruises",".csc",".cu",".cuisinella",".cv",".cw",".cx",".cy",".cymru",".cyou",".cz",".dabur",".dad",".dance",".data",".date",".dating",".datsun",".day",".dclk",".dds",".de",".deal",".dealer",".deals",".degree",".delivery",".dell",".deloitte",".delta",".democrat",".dental",".dentist",".desi",".design",".dev",".dhl",".diamonds",".diet",".digital",".direct",".directory",".discount",".discover",".dish",".diy",".dj",".dk",".dm",".dnp",".do",".docs",".doctor",".dodge",".dog",".doha",".domains",".doosan",".dot",".download",".drive",".dtv",".dubai",".duck",".dunlop",".duns",".dupont",".durban",".dvag",".dvr",".dz",".earth",".eat",".ec",".eco",".edeka",".edu",".education",".ee",".eg",".eh",".email",".emerck",".energy",".engineer",".engineering",".enterprises",".epost",".epson",".equipment",".er",".ericsson",".erni",".es",".esq",".estate",".esurance",".et",".etisalat",".eu",".eurovision",".eus",".events",".everbank",".exchange",".expert",".exposed",".express",".extraspace",".fage",".fail",".fairwinds",".faith",".family",".fan",".fans",".farm",".farmers",".fashion",".fast",".fedex",".feedback",".ferrari",".ferrero",".fi",".fiat",".fidelity",".fido",".film",".final",".finance",".financial",".fire",".firestone",".firmdale",".fish",".fishing",".fit",".fitness",".fj",".fk",".flickr",".flights",".flir",".florist",".flowers",".flsmidth",".fly",".fm",".fo",".foo",".food",".foodnetwork",".football",".ford",".forex",".forsale",".forum",".foundation",".fox",".fr",".free",".fresenius",".frl",".frogans",".frontdoor",".frontier",".ftr",".fujitsu",".fujixerox",".fun",".fund",".furniture",".futbol",".fyi",".ga",".gal",".gallery",".gallo",".gallup",".game",".games",".gap",".garden",".gb",".gbiz",".gd",".gdn",".ge",".gea",".gent",".genting",".george",".gf",".gg",".ggee",".gh",".gi",".gift",".gifts",".gives",".giving",".gl",".glade",".glass",".gle",".global",".globo",".gm",".gmail",".gmbh",".gmo",".gmx",".gn",".godaddy",".gold",".goldpoint",".golf",".goo",".goodhands",".goodyear",".goog",".google",".gop",".got",".gov",".gp",".gq",".gr",".grainger",".graphics",".gratis",".green",".gripe",".group",".gs",".gt",".gu",".guardian",".gucci",".guge",".guide",".guitars",".guru",".gw",".gy",".hair",".hamburg",".hangout",".haus",".hbo",".hdfc",".hdfcbank",".health",".healthcare",".help",".helsinki",".here",".hermes",".hgtv",".hiphop",".hisamitsu",".hitachi",".hiv",".hk",".hkt",".hm",".hn",".hockey",".holdings",".holiday",".homedepot",".homegoods",".homes",".homesense",".honda",".honeywell",".horse",".hospital",".host",".hosting",".hot",".hoteles",".hotels",".hotmail",".house",".how",".hr",".hsbc",".ht",".htc",".hu",".hughes",".hyatt",".hyundai",".ibm",".icbc",".ice",".icu",".id",".ie",".ieee",".ifm",".iinet",".ikano",".il",".im",".imamat",".imdb",".immo",".immobilien",".in",".industries",".infiniti",".info",".ing",".ink",".institute",".insurance",".insure",".int",".intel",".international",".intuit",".investments",".io",".ipiranga",".iq",".ir",".irish",".is",".iselect",".ismaili",".ist",".istanbul",".it",".itau",".itv",".iveco",".iwc",".jaguar",".java",".jcb",".jcp",".je",".jeep",".jetzt",".jewelry",".jio",".jlc",".jll",".jm",".jmp",".jnj",".jo",".jobs",".joburg",".jot",".joy",".jp",".jpmorgan",".jprs",".juegos",".juniper",".kaufen",".kddi",".ke",".kerryhotels",".kerrylogistics",".kerryproperties",".kfh",".kg",".kh",".ki",".kia",".kim",".kinder",".kindle",".kitchen",".kiwi",".km",".kn",".koeln",".komatsu",".kosher",".kp",".kpmg",".kpn",".kr",".krd",".kred",".kuokgroup",".kw",".ky",".kyoto",".kz",".la",".lacaixa",".ladbrokes",".lamborghini",".lamer",".lancaster",".lancia",".lancome",".land",".landrover",".lanxess",".lasalle",".lat",".latino",".latrobe",".law",".lawyer",".lb",".lc",".lds",".lease",".leclerc",".lefrak",".legal",".lego",".lexus",".lgbt",".li",".liaison",".lidl",".life",".lifeinsurance",".lifestyle",".lighting",".like",".lilly",".limited",".limo",".lincoln",".linde",".link",".lipsy",".live",".living",".lixil",".lk",".loan",".loans",".locker",".locus",".loft",".lol",".london",".lotte",".lotto",".love",".lpl",".lplfinancial",".lr",".ls",".lt",".ltd",".ltda",".lu",".lundbeck",".lupin",".luxe",".luxury",".lv",".ly",".ma",".macys",".madrid",".maif",".maison",".makeup",".man",".management",".mango",".market",".marketing",".markets",".marriott",".marshalls",".maserati",".mattel",".mba",".mc",".mcd",".mcdonalds",".mckinsey",".md",".me",".med",".media",".meet",".melbourne",".meme",".memorial",".men",".menu",".meo",".metlife",".mf",".mg",".mh",".miami",".microsoft",".mil",".mini",".mint",".mit",".mitsubishi",".mk",".ml",".mlb",".mls",".mm",".mma",".mn",".mo",".mobi",".mobile",".mobily",".moda",".moe",".moi",".mom",".monash",".money",".monster",".montblanc",".mopar",".mormon",".mortgage",".moscow",".moto",".motorcycles",".mov",".movie",".movistar",".mp",".mq",".mr",".ms",".msd",".mt",".mtn",".mtpc",".mtr",".mu",".museum",".mutual",".mutuelle",".mv",".mw",".mx",".my",".mz",".na",".nab",".nadex",".nagoya",".name",".nationwide",".natura",".navy",".nba",".nc",".ne",".nec",".net",".netbank",".netflix",".network",".neustar",".new",".newholland",".news",".next",".nextdirect",".nexus",".nf",".nfl",".ng",".ngo",".nhk",".ni",".nico",".nike",".nikon",".ninja",".nissan",".nissay",".nl",".no",".nokia",".northwesternmutual",".norton",".now",".nowruz",".nowtv",".np",".nr",".nra",".nrw",".ntt",".nu",".nyc",".nz",".obi",".observer",".off",".office",".okinawa",".olayan",".olayangroup",".oldnavy",".ollo",".om",".omega",".one",".ong",".onl",".online",".onyourside",".ooo",".open",".oracle",".orange",".org",".organic",".orientexpress",".origins",".osaka",".otsuka",".ott",".ovh",".pa",".page",".pamperedchef",".panasonic",".panerai",".paris",".pars",".partners",".parts",".party",".passagens",".pay",".pccw",".pe",".pet",".pf",".pfizer",".pg",".ph",".pharmacy",".philips",".phone",".photo",".photography",".photos",".physio",".piaget",".pics",".pictet",".pictures",".pid",".pin",".ping",".pink",".pioneer",".pizza",".pk",".pl",".place",".play",".playstation",".plumbing",".plus",".pm",".pn",".pnc",".pohl",".poker",".politie",".porn",".post",".pr",".pramerica",".praxi",".press",".prime",".pro",".prod",".productions",".prof",".progressive",".promo",".properties",".property",".protection",".pru",".prudential",".ps",".pt",".pub",".pw",".pwc",".py",".qa",".qpon",".quebec",".quest",".qvc",".racing",".radio",".raid",".re",".read",".realestate",".realtor",".realty",".recipes",".red",".redstone",".redumbrella",".rehab",".reise",".reisen",".reit",".reliance",".ren",".rent",".rentals",".repair",".report",".republican",".rest",".restaurant",".review",".reviews",".rexroth",".rich",".richardli",".ricoh",".rightathome",".ril",".rio",".rip",".rmit",".ro",".rocher",".rocks",".rodeo",".rogers",".room",".rs",".rsvp",".ru",".rugby",".ruhr",".run",".rw",".rwe",".ryukyu",".sa",".saarland",".safe",".safety",".sakura",".sale",".salon",".samsclub",".samsung",".sandvik",".sandvikcoromant",".sanofi",".sap",".sapo",".sarl",".sas",".save",".saxo",".sb",".sbi",".sbs",".sc",".sca",".scb",".schaeffler",".schmidt",".scholarships",".school",".schule",".schwarz",".science",".scjohnson",".scor",".scot",".sd",".se",".seat",".secure",".security",".seek",".select",".sener",".services",".ses",".seven",".sew",".sex",".sexy",".sfr",".sg",".sh",".shangrila",".sharp",".shaw",".shell",".shia",".shiksha",".shoes",".shop",".shopping",".shouji",".show",".showtime",".shriram",".si",".silk",".sina",".singles",".site",".sj",".sk",".ski",".skin",".sky",".skype",".sl",".sling",".sm",".smart",".smile",".sn",".sncf",".so",".soccer",".social",".softbank",".software",".sohu",".solar",".solutions",".song",".sony",".soy",".space",".spiegel",".spot",".spreadbetting",".sr",".srl",".srt",".ss",".st",".stada",".staples",".star",".starhub",".statebank",".statefarm",".statoil",".stc",".stcgroup",".stockholm",".storage",".store",".stream",".studio",".study",".style",".su",".sucks",".supplies",".supply",".support",".surf",".surgery",".suzuki",".sv",".swatch",".swiftcover",".swiss",".sx",".sy",".sydney",".symantec",".systems",".sz",".tab",".taipei",".talk",".taobao",".target",".tatamotors",".tatar",".tattoo",".tax",".taxi",".tc",".tci",".td",".tdk",".team",".tech",".technology",".tel",".telecity",".telefonica",".temasek",".tennis",".teva",".tf",".tg",".th",".thd",".theater",".theatre",".tiaa",".tickets",".tienda",".tiffany",".tips",".tires",".tirol",".tj",".tjmaxx",".tjx",".tk",".tkmaxx",".tl",".tm",".tmall",".tn",".to",".today",".tokyo",".tools",".top",".toray",".toshiba",".total",".tours",".town",".toyota",".toys",".tp",".tr",".trade",".trading",".training",".travel",".travelchannel",".travelers",".travelersinsurance",".trust",".trv",".tt",".tube",".tui",".tunes",".tushu",".tv",".tvs",".tw",".tz",".ua",".ubank",".ubs",".uconnect",".ug",".uk",".um",".unicom",".university",".uno",".uol",".ups",".us",".uy",".uz",".va",".vacations",".vana",".vanguard",".vc",".ve",".vegas",".ventures",".verisign",".versicherung",".vet",".vg",".vi",".viajes",".video",".vig",".viking",".villas",".vin",".vip",".virgin",".visa",".vision",".vista",".vistaprint",".viva",".vivo",".vlaanderen",".vn",".vodka",".volkswagen",".volvo",".vote",".voting",".voto",".voyage",".vu",".vuelos",".wales",".walmart",".walter",".wang",".wanggou",".warman",".watch",".watches",".weather",".weatherchannel",".webcam",".weber",".website",".wed",".wedding",".weibo",".weir",".wf",".whoswho",".wien",".wiki",".williamhill",".win",".windows",".wine",".winners",".wme",".wolterskluwer",".woodside",".work",".works",".world",".wow",".ws",".wtc",".wtf",".xbox",".xerox",".xfinity",".xihuan",".xin",
*/};


private String invalidTopLevelDomains[] = {".tc+(8",".N/KUB",".8H[3z",".=Iydj",".;)!r)",".VKnqe",".asMdf",".!7a*v",".*(X4(",".!sHN6",".&jg3e",".n<%+q",".&2Q_f","..2AZb",".3MIzv",".O*M[3",".a3!:2","..,3wS",".gKNJP","..x@H+",".SLvmr",".Sj+>@",".^@I6z",".!IDRQ",".g)7/l",".^Kbu#",".j]vO!",".4M/.w",".nr>=f",".[}kYY",".n<{-f",".<vCGB",".+6>5J",".SXiye",".(x_$X",".>p=j4",".mSoE<",".b2=#H",".$$zaV",".cZD-*", 
".Mwvd",".tSmb",".MtcK",".msaK",".Qkgd",".aykc",".Jyyl",".hCmy",".vGDG",".sSJU",".LtJe",".CrGP",".CaxB",".axIa",".tUPF",".rmRy",".qXoZ",".BwRX",".BEVy",".iBgn",".vrOq",".NJrQ",".BwXJ",".aOdi",".tcMv",".RfxJ",".xwsi",".GAZL",".QwpR",".Ouew",".tQzK",".yrgb",".jHFp",".bUKM",".KZWc",".jqBK",".qRoc",".rzwe",".QHzQ",".Ioom", "", "%$", "^^AS", "?%221", ">com"};


private String invalidDomainNames[] = { "aaa.google", "ww.google", "www,google", "www.google,", "www.google\".com", "www.fo@''"};
private String invalidIpAddresses[] = {"1.22.33", "10000.255.255.255", "", "1,3,4,5"};

private String validDomainNames[] = {"www.google", "google", "200", "www.google220"};
private String validIpAddresses[] = {"120.200.5.5", "0.0.0.0", /*"[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]","[1080:0:0:0:8:800:200C:4171]","[3ffe:2a00:100:7031::1]","[1080::8:800:200C:417A]","[::192.9.5.5]","[::FFFF:129.144.52.38]","[2010:836B:4179::836B:4179]"*/};

private String validPorts[] = {":0", ":100", ":65535", ":14900", "" };
private String invalidPorts[] = {":asc", ":#$", ":-12", ":999999", ":65536", "::"};
private ResultPair validPaths[] = { new ResultPair("/test1", true), new ResultPair("/t123", true), new ResultPair("/$23", true), new ResultPair("/test1/", true), new ResultPair("", true), new ResultPair("/test1/file", true), new ResultPair("/t123/file", true), new ResultPair("/$23/file", true), new ResultPair("/test1/file", true), new ResultPair("/%3Fabc/files", true) };
private ResultPair invalidPaths[] = { new ResultPair("/..", false),  new ResultPair("/../", false), new ResultPair("/../file", false), new ResultPair("/..//file", false), new ResultPair("//key", false),  new ResultPair(":/files", false) }; 


private String validQueries[] = {"?", "", "?item1=value1;item2=value2", "?item1/value1?item1=value2", "?item1", "?item1?=value1", "??=?", "?item1=1+2+some+words"};

public ResultPair[] makeValidSchemes() {
 int usedValidNumbers[] = new int[numValidSchemes] ;
 int randomNum;
 ResultPair schemes[] = new ResultPair[numValidSchemes];

 for (int i=0; i< numValidSchemes; i++) {
   do {
     randomNum = ThreadLocalRandom.current().nextInt(0, validSchemes.length);

   } while (Arrays.asList(usedValidNumbers).contains(randomNum) == true);
   usedValidNumbers[i] = randomNum;
   schemes[i] = new ResultPair(validSchemes[randomNum], true);
 }
 return schemes;
}

public ResultPair[] makeInvalidScheme() {
int usedInvalidNumbers[] = new int[numInvalidSchemes];
int randomNum;
ResultPair schemes[] = new ResultPair[numInvalidSchemes];
for (int j=0; j < numInvalidSchemes; j++) {
 do {
     randomNum = ThreadLocalRandom.current().nextInt(0, invalidSchemes.length);

   } while (Arrays.asList(usedInvalidNumbers).contains(randomNum) == true);
   usedInvalidNumbers[j] = randomNum;
   schemes[j] = new ResultPair(invalidSchemes[randomNum], false);
 }
 return schemes;
}

//Use StringBuffer
public ResultPair[] makeFullValidDomains() {
int numValidDomains = 10;
int usedValidNumbers[] = new int[numValidDomains];
ResultPair fullDomains[] = new ResultPair[numValidDomains];
int randomNum;

for (int i=0; i< numValidDomains; i++) {
 StringBuffer testBuffer = new StringBuffer();
 // Ensure no duplicates
 do {
       randomNum = ThreadLocalRandom.current().nextInt(0, validTopLevelDomains.length);

     } while (Arrays.asList(usedValidNumbers).contains(randomNum) == true);
     // Attach a valid base domain to string buffer first, before putting on the top-level part
     testBuffer.append(validDomainNames[i % validDomainNames.length]);
     testBuffer.append(validTopLevelDomains[randomNum]);
     fullDomains[i] = new ResultPair(testBuffer.toString(), true);
}
return fullDomains;
}

//Use StringBuffer
public ResultPair[] makeFullInvalidDomains() {
int numInvalidDomains = 10;
int usedInvalidNumbers[] = new int[numInvalidDomains];
ResultPair fullDomains[] = new ResultPair[numInvalidDomains];
int randomNum;

for (int i=0; i< numInvalidDomains; i++) {
 StringBuffer testBuffer = new StringBuffer();
 // Ensure no duplicates
 do {
       randomNum = ThreadLocalRandom.current().nextInt(0, invalidTopLevelDomains.length);

     } while (Arrays.asList(usedInvalidNumbers).contains(randomNum) == true);
     // Attach a invalid base domain to string buffer first, before putting on the top-level part
     if ( (randomNum % 2) == 0)
       testBuffer.append(invalidDomainNames[i % invalidDomainNames.length]);
     else
       testBuffer.append(validDomainNames[i % validDomainNames.length]);
     testBuffer.append(invalidTopLevelDomains[randomNum]);
     fullDomains[i] = new ResultPair(testBuffer.toString(), false);
}
return fullDomains;
}

//Valid authorities have full domains or IP addresses and, optionally, port numbers
//Parameters: Array of valid domain result-pairs, that is, {validExample.com, true}
//Output: Array of valid authorities consisting of result pairs of valid domains or IP addresses with valid ports attached
public ResultPair[] makeValidAuthorityPairs(ResultPair[] validDomains) {
ResultPair authorities[] = new ResultPair[numValidAuthorities];
int randomIp, randomPort;
for (int i=0; i < numValidAuthorities; i++) {
     StringBuffer testBuffer = new StringBuffer();

     // Append a random valid port to each valid domain
     randomPort = ThreadLocalRandom.current().nextInt(0, validPorts.length);

     // Also use this random number to determine whether to use an ip address or domain name
     if ( (randomPort % 2) == 0) {
       testBuffer.append(validDomains[i%validDomains.length].item);
     }
     else {
       randomIp = ThreadLocalRandom.current().nextInt(0, validIpAddresses.length);
       testBuffer.append(validIpAddresses[randomIp]);
       }
     // Now assign the port
       testBuffer.append(validPorts[randomPort]);
       authorities[i] = new ResultPair(testBuffer.toString(), true);
}
 return authorities;
}


//Make random mix of invalid 
public ResultPair[] makeInvalidAuthorityPairs(ResultPair[] invalidDomains, ResultPair[] validDomains) {
ResultPair authorities[] = new ResultPair[numInvalidAuthorities];
int randomPort;
int useValidPort;
for (int i=0; i < numInvalidAuthorities; i++) {
     StringBuffer testBuffer = new StringBuffer();

     useValidPort = (ThreadLocalRandom.current().nextInt(0,10) % 2);
     // Append a random invalid port to each invalid domain
     if ( useValidPort == 0) {
       testBuffer.append(validDomains[i%validDomains.length].item);
       randomPort = ThreadLocalRandom.current().nextInt(0, invalidPorts.length);
       testBuffer.append(invalidPorts[randomPort]);
     }
     else {
       testBuffer.append(invalidDomains[i%invalidDomains.length].item);
       randomPort = ThreadLocalRandom.current().nextInt(0, validPorts.length);
       testBuffer.append(validPorts[randomPort]);
     }
       authorities[i] = new ResultPair(testBuffer.toString(), true);
}
 return authorities;
}


public int[] classValidTests() {
	int counter = 0;
	int errors = 0;
	int SB_Length = 300;
UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
ResultPair validSchemesM[] = makeValidSchemes();
ResultPair invalidSchemesM[] = makeInvalidScheme();

//Use these two for use in making authorities
ResultPair validDomainsM[] = makeFullValidDomains();
ResultPair invalidDomainsM[] = makeFullInvalidDomains();

ResultPair validAuthoritiesM[] = makeValidAuthorityPairs(validDomainsM);
ResultPair invalidAuthoritiesM[] = makeInvalidAuthorityPairs(invalidDomainsM, validDomainsM);
StringBuffer testBuffer = new StringBuffer();

// Test all full URLs which are expected to be valid

for (int i=0; i < validSchemesM.length; i++) {
 testBuffer.append(validSchemesM[i].item);
 for (int j=0; j < validAuthoritiesM.length; j++) {
   testBuffer.append(validAuthoritiesM[j].item);
   int authorityIndex = testBuffer.lastIndexOf(validAuthoritiesM[j].item);
   for (int k=0; k < validPaths.length; k++) {
     testBuffer.append(validPaths[k].item);
     int pathIndex = testBuffer.lastIndexOf(validPaths[k].item);
     for (int m=0; m < validQueries.length; m++) {
       testBuffer.append(validQueries[m]);
       boolean result = urlVal.isValid(testBuffer.toString());
       counter++;
       if (result != true) {
    	   System.out.print("Error: should be true " + testBuffer.toString() + "\n");
    	   errors++;
       }
       int queryIndex = testBuffer.lastIndexOf(validQueries[m]);
       testBuffer.delete(queryIndex, SB_Length);
     }
     testBuffer.delete(pathIndex, SB_Length);
   }
   testBuffer.delete(authorityIndex, SB_Length);
 }
 testBuffer.setLength(0);
}
	//COMMENTED OUT TEMPORARILY TO LOCATE VALID-BUT-UNACCEPTED URLS
testBuffer = new StringBuffer();

//Invalid URLs which only have invalid paths - tests should be false
for (int i=0; i < validSchemesM.length; i++) {
 testBuffer.append(validSchemesM[i].item);
 for (int j=0; j < validAuthoritiesM.length; j++) {
   testBuffer.append(validAuthoritiesM[j].item);
   int authorityIndex = testBuffer.lastIndexOf(validAuthoritiesM[j].item);
   for (int k=0; k < invalidPaths.length; k++) {
     testBuffer.append(invalidPaths[k].item);
     int pathIndex = testBuffer.lastIndexOf(invalidPaths[k].item);
     for (int m=0; m < validQueries.length; m++) {
       testBuffer.append(validQueries[m]);
       boolean result = urlVal.isValid(testBuffer.toString());
       counter++;
       if (result != false) {
    	   System.out.print("Error: should be false " + testBuffer.toString() + "\n");
    	   errors++;
       }
       int queryIndex = testBuffer.lastIndexOf(validQueries[m]);
       testBuffer.delete(queryIndex, SB_Length);
     }
     testBuffer.delete(pathIndex, SB_Length);
   }
   testBuffer.delete(authorityIndex, SB_Length);
 }
 testBuffer.setLength(0);

}

testBuffer = new StringBuffer();

 // Invalid authorities only - tests should be false
for (int i=0; i < validSchemesM.length; i++) {
 testBuffer.append(validSchemesM[i].item);
 for (int j=0; j < invalidAuthoritiesM.length; j++) {
   testBuffer.append(invalidAuthoritiesM[j].item);
   int authorityIndex = testBuffer.lastIndexOf(invalidAuthoritiesM[j].item);
   for (int k=0; k < validPaths.length; k++) {
     testBuffer.append(validPaths[k].item);
     int pathIndex = testBuffer.lastIndexOf(validPaths[k].item);
     for (int m=0; m < validQueries.length; m++) {
       testBuffer.append(validQueries[m]);
       boolean result = urlVal.isValid(testBuffer.toString());
       counter++;
       if (result != false) {
    	   System.out.print("Error: should be false " + testBuffer.toString() + "\n");
    	   errors++;
       }
       int queryIndex = testBuffer.lastIndexOf(validQueries[m]);
       testBuffer.delete(queryIndex, SB_Length);
     }
     testBuffer.delete(pathIndex, SB_Length);
   }
   testBuffer.delete(authorityIndex, SB_Length);
 }
 testBuffer.setLength(0);

} 

testBuffer = new StringBuffer();

 // Invalid Schemes only - tests should be false
for (int i=0; i < invalidSchemesM.length; i++) {

 testBuffer.append(invalidSchemesM[i].item);
 for (int j=0; j < validAuthoritiesM.length; j++) {
   testBuffer.append(validAuthoritiesM[j].item);
   int authorityIndex = testBuffer.lastIndexOf(validAuthoritiesM[j].item);
   for (int k=0; k < validPaths.length; k++) {
     testBuffer.append(validPaths[k].item);
     int pathIndex = testBuffer.lastIndexOf(validPaths[k].item);
     for (int m=0; m < validQueries.length; m++) {
       testBuffer.append(validQueries[m]);
       boolean result = urlVal.isValid(testBuffer.toString());
       counter++;
       if (result != false) {
    	   System.out.print("Error: should be false " + testBuffer.toString() + "\n");
    	   errors++;
       }
       int queryIndex = testBuffer.lastIndexOf(validQueries[m]);
       testBuffer.delete(queryIndex, SB_Length);
     }
     testBuffer.delete(pathIndex, SB_Length);
   }
   testBuffer.delete(authorityIndex, SB_Length);
 }
 testBuffer.setLength(0);

}

testBuffer = new StringBuffer();

   // Invalid schemes, authorities, and paths - tests should be false
for (int i=0; i < invalidSchemesM.length; i++) {
 testBuffer.append(invalidSchemesM[i].item);
 for (int j=0; j < invalidAuthoritiesM.length; j++) {
   testBuffer.append(invalidAuthoritiesM[j].item);
   int authorityIndex = testBuffer.lastIndexOf(invalidAuthoritiesM[j].item);
   for (int k=0; k < invalidPaths.length; k++) {
     testBuffer.append(invalidPaths[k].item);
     int pathIndex = testBuffer.lastIndexOf(invalidPaths[k].item);
     for (int m=0; m < validQueries.length; m++) {
       testBuffer.append(validQueries[m]);
       boolean result = urlVal.isValid(testBuffer.toString());
       counter++;
       if (result != false) {
    	   System.out.print("Error: Should be false " + testBuffer.toString() + "\n");
    	   errors++;
       }
       int queryIndex = testBuffer.lastIndexOf(validQueries[m]);
       testBuffer.delete(queryIndex, SB_Length);
     }
     testBuffer.delete(pathIndex, SB_Length);
   }
   testBuffer.delete(authorityIndex, SB_Length);
 }
 testBuffer.setLength(0);

} 
	//System.out.print("Total Tests: " + Integer.toString(counter) + "\nErrors: " + Integer.toString(errors) + "\n");

	int testErrors[] = {counter, errors};
	return testErrors;
}


//The below manual tests are all invalid according to RFC 3986:  https://tools.ietf.org/html/rfc3986#section-3.1
public void manualValidTests() {
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     boolean result = false;
     String strings[] =  {"ftp://ftp.is.co.za/rfc/rfc1808.txt",
    		 "http://www.ietf.org/rfc/rfc2396.txt",
    		 "ldap://www.google.com/c=GB?objectClass?one",
    		 "mailto:John.Doe@example.com",
    		  "news:comp.infosystems.www.servers.unix",
    		 "tel:+1-816-555-1212",
    		 "telnet://192.0.2.16:80/",
    		 "urn:oasis:names:specification:docbook:dtd:xml:4.1.2" };
     for (int i=0; i< strings.length; i++) {
    	 if (urlVal.isValid(strings[i]) == result)
    		 System.out.print("Deemed Invalid " + strings[i] + "\n");
     }
}

public void main() {
	int totalTests = 0;
	int errors = 0;
	for (int i=0; i<timesToRunSuiteInMain; i++) {
		int results[] = classValidTests();
		totalTests += results[0];
		errors += results[1];
	}
	
	
	System.out.print("Total Tests: " + Integer.toString(totalTests) + "\nErrors: " + Integer.toString(errors) + "\n");
	
}

}