// Generated from StreamQl.g4 by ANTLR 4.2.2

    package deephacks.streamql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StreamQlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, STRING=9,
		NUMBER=10, DECIMAL=11, NULL=12, TRUE=13, FALSE=14, AND=15, OR=16, NOT=17,
		EQ=18, NT_EQ=19, LT_EQ=20, GT_EQ=21, GT=22, LT=23, CONTAINS=24, STARTS_WITH=25,
		ENDS_WITH=26, REGEXP=27, ID=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'ordered'", "'reversed'", "'limit'", "'('", "'filter'", "')'", "','",
		"'skip'", "STRING", "NUMBER", "DECIMAL", "'null'", "'true'", "'false'",
		"'&&'", "'||'", "'!'", "'=='", "'!='", "'<='", "'>='", "'>'", "'<'", "'contains'",
		"'startsWith'", "'endsWith'", "'regExp'", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "QUOTE",
		"STRING", "NUMBER", "DECIMAL", "INT", "NULL", "TRUE", "FALSE", "AND",
		"OR", "NOT", "EQ", "NT_EQ", "LT_EQ", "GT_EQ", "GT", "LT", "CONTAINS",
		"STARTS_WITH", "ENDS_WITH", "REGEXP", "ID", "WS"
	};


	public StreamQlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "StreamQl.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\7\13o\n\13\f\13\16\13r\13"+
		"\13\3\13\3\13\3\f\5\fw\n\f\3\f\3\f\3\r\5\r|\n\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\7\16\u0085\n\16\f\16\16\16\u0088\13\16\5\16\u008a\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\6\37\u00d9\n\37\r\37\16\37\u00da\3 \6 \u00de"+
		"\n \r \16 \u00df\3 \3 \3p\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25"+
		"\13\27\f\31\r\33\2\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30"+
		"\63\31\65\32\67\339\34;\35=\36?\37\3\2\6\3\2\63;\3\2\62;\t\2&&\60\60\62"+
		";C\\^^aac|\5\2\13\f\17\17\"\"\u00e7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5I\3\2\2\2\7R\3\2\2\2"+
		"\tX\3\2\2\2\13Z\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23j\3\2\2\2"+
		"\25l\3\2\2\2\27v\3\2\2\2\31{\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2\2"+
		"\37\u0090\3\2\2\2!\u0095\3\2\2\2#\u009b\3\2\2\2%\u009e\3\2\2\2\'\u00a1"+
		"\3\2\2\2)\u00a3\3\2\2\2+\u00a6\3\2\2\2-\u00a9\3\2\2\2/\u00ac\3\2\2\2\61"+
		"\u00af\3\2\2\2\63\u00b1\3\2\2\2\65\u00b3\3\2\2\2\67\u00bc\3\2\2\29\u00c7"+
		"\3\2\2\2;\u00d0\3\2\2\2=\u00d8\3\2\2\2?\u00dd\3\2\2\2AB\7q\2\2BC\7t\2"+
		"\2CD\7f\2\2DE\7g\2\2EF\7t\2\2FG\7g\2\2GH\7f\2\2H\4\3\2\2\2IJ\7t\2\2JK"+
		"\7g\2\2KL\7x\2\2LM\7g\2\2MN\7t\2\2NO\7u\2\2OP\7g\2\2PQ\7f\2\2Q\6\3\2\2"+
		"\2RS\7n\2\2ST\7k\2\2TU\7o\2\2UV\7k\2\2VW\7v\2\2W\b\3\2\2\2XY\7*\2\2Y\n"+
		"\3\2\2\2Z[\7h\2\2[\\\7k\2\2\\]\7n\2\2]^\7v\2\2^_\7g\2\2_`\7t\2\2`\f\3"+
		"\2\2\2ab\7+\2\2b\16\3\2\2\2cd\7.\2\2d\20\3\2\2\2ef\7u\2\2fg\7m\2\2gh\7"+
		"k\2\2hi\7r\2\2i\22\3\2\2\2jk\7)\2\2k\24\3\2\2\2lp\5\23\n\2mo\13\2\2\2"+
		"nm\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\5\23\n"+
		"\2t\26\3\2\2\2uw\7/\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\5\33\16\2y\30"+
		"\3\2\2\2z|\7/\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5\33\16\2~\177\7\60"+
		"\2\2\177\u0080\5\33\16\2\u0080\32\3\2\2\2\u0081\u008a\7\62\2\2\u0082\u0086"+
		"\t\2\2\2\u0083\u0085\t\3\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u008a\34\3\2\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7w\2\2\u008d\u008e\7n\2\2\u008e\u008f\7n\2\2\u008f"+
		"\36\3\2\2\2\u0090\u0091\7v\2\2\u0091\u0092\7t\2\2\u0092\u0093\7w\2\2\u0093"+
		"\u0094\7g\2\2\u0094 \3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7c\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7u\2\2\u0099\u009a\7g\2\2\u009a\"\3\2\2\2\u009b"+
		"\u009c\7(\2\2\u009c\u009d\7(\2\2\u009d$\3\2\2\2\u009e\u009f\7~\2\2\u009f"+
		"\u00a0\7~\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7#\2\2\u00a2(\3\2\2\2\u00a3\u00a4"+
		"\7?\2\2\u00a4\u00a5\7?\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8,\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa\u00ab\7?\2\2\u00ab.\3"+
		"\2\2\2\u00ac\u00ad\7@\2\2\u00ad\u00ae\7?\2\2\u00ae\60\3\2\2\2\u00af\u00b0"+
		"\7@\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\64\3\2\2\2\u00b3\u00b4"+
		"\7e\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\u00b8\7c\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7u\2\2"+
		"\u00bb\66\3\2\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7"+
		"c\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3"+
		"\7Y\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7j\2\2\u00c6"+
		"8\3\2\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7f\2\2\u00ca"+
		"\u00cb\7u\2\2\u00cb\u00cc\7Y\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7v\2\2"+
		"\u00ce\u00cf\7j\2\2\u00cf:\3\2\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7g\2"+
		"\2\u00d2\u00d3\7i\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d5\7z\2\2\u00d5\u00d6"+
		"\7r\2\2\u00d6<\3\2\2\2\u00d7\u00d9\t\4\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db>\3\2\2\2\u00dc"+
		"\u00de\t\5\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b \2\2\u00e2"+
		"@\3\2\2\2\n\2pv{\u0086\u0089\u00da\u00df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}