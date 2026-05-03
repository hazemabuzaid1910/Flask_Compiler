// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/FlaskLexer.g4 by ANTLR 4.13.2
package antler;
import java.util.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FlaskLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, NEWLINE=3, WS=4, COMMENT=5, DEF=6, IF=7, ELIF=8, ELSE=9, 
		RETURN=10, FOR=11, IN=12, FROM=13, IMPORT=14, NONE=15, TRUE=16, FALSE=17, 
		WITH=18, AS=19, AND=20, OR=21, NOT=22, ROUTE=23, EQEQ=24, NEQ=25, LE=26, 
		GE=27, LT=28, GT=29, PLUS=30, MINUS=31, MUL=32, DIV=33, MOD=34, ASSIGN=35, 
		AT=36, DOT=37, LPAREN=38, RPAREN=39, LBRACK=40, RBRACK=41, LBRACE=42, 
		RBRACE=43, COMMA=44, COLON=45, SEMICOLON=46, IDENTIFIER=47, STRING=48, 
		NUMBER=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "SPACE", "WS", "COMMENT", "DEF", "IF", "ELIF", "ELSE", "RETURN", 
			"FOR", "IN", "FROM", "IMPORT", "NONE", "TRUE", "FALSE", "WITH", "AS", 
			"AND", "OR", "NOT", "ROUTE", "EQEQ", "NEQ", "LE", "GE", "LT", "GT", "PLUS", 
			"MINUS", "MUL", "DIV", "MOD", "ASSIGN", "AT", "DOT", "LPAREN", "RPAREN", 
			"LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", "COLON", "SEMICOLON", 
			"IDENTIFIER", "STRING", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'def'", "'if'", "'elif'", "'else'", 
			"'return'", "'for'", "'in'", "'from'", "'import'", "'None'", "'True'", 
			"'False'", "'with'", "'as'", "'and'", "'or'", "'not'", "'route'", "'=='", 
			"'!='", "'<='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'='", "'@'", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", "','", 
			"':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "NEWLINE", "WS", "COMMENT", "DEF", "IF", "ELIF", 
			"ELSE", "RETURN", "FOR", "IN", "FROM", "IMPORT", "NONE", "TRUE", "FALSE", 
			"WITH", "AS", "AND", "OR", "NOT", "ROUTE", "EQEQ", "NEQ", "LE", "GE", 
			"LT", "GT", "PLUS", "MINUS", "MUL", "DIV", "MOD", "ASSIGN", "AT", "DOT", 
			"LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", 
			"COLON", "SEMICOLON", "IDENTIFIER", "STRING", "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



	    private Stack<Integer> indents = new Stack<>() {{ push(0); }};
	    private Queue<Token> queue = new LinkedList<>();

	    // يمنع احتساب indentation داخل الأقواس
	    private int opened = 0;

	    // (اختياري) debug
	    private boolean debug = false;

	    @Override
	    public Token nextToken() {

	        // إذا في tokens مولّدة مسبقاً (INDENT / DEDENT / NEWLINE)
	        if (!queue.isEmpty())
	            return queue.poll();

	        Token t = super.nextToken();
	if (t.getType() == EOF) {
	        // طالما أن الستاك فيه مستويات إزاحة أكثر من المستوى الابتدائي (0)
	        while (indents.size() > 1) {
	            indents.pop();
	            queue.add(createToken(DEDENT, "")); // أضف DEDENT لكل مستوى
	        }
	        queue.add(t); // أضف الـ EOF في النهاية
	        return queue.poll();
	    }
	        // تتبع الأقواس حتى لا نحسب indent داخلها
	        if (t.getType() == LPAREN || t.getType() == LBRACK || t.getType() == LBRACE)
	            opened++;

	        if (t.getType() == RPAREN || t.getType() == RBRACK || t.getType() == RBRACE)
	            opened--;

	      if (t.getType() == NEWLINE) {

	          queue.add(t);

	          int spaces = 0;
	          int i = 1;
	          int la = _input.LA(i);

	          // ⬅️ قراءة المسافات الحقيقية بعد السطر
	          while (la == ' ' || la == '\t') {
	              spaces += (la == '\t') ? 4 : 1;
	              i++;
	              la = _input.LA(i);
	          }

	          int current = indents.peek();

	          if (debug) {
	              System.out.println("SPACES = " + spaces + " CURRENT = " + current);
	          }

	          if (opened == 0) {

	              if (spaces > current) {
	                  indents.push(spaces);

	                  //System.out.println(">>> INDENT = " + spaces);

	                  queue.add(createToken(INDENT, String.valueOf(spaces))); // 👈 مهم
	              }

	              else if (spaces < current) {
	                  while (indents.size() > 1 && indents.peek() > spaces) {
	                      indents.pop();

	                      //System.out.println(">>> DEDENT = " + spaces);

	                      queue.add(createToken(DEDENT, String.valueOf(spaces))); // 👈 مهم
	                  }
	              }
	          }

	          return queue.poll();
	      }
	        return t;
	    }

	    // إنشاء token يدوي (INDENT / DEDENT)
	    private Token createToken(int type, String text) {
	        CommonToken token = new CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, -1, -1);
	        token.setText(text);
	        return token;
	    }


	public FlaskLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FlaskLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u00001\u0136\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000"+
		"\u0003\u0000c\b\u0000\u0001\u0000\u0004\u0000f\b\u0000\u000b\u0000\f\u0000"+
		"g\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002m\b\u0002\u000b\u0002"+
		"\f\u0002n\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003"+
		"u\b\u0003\n\u0003\f\u0003x\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001"+
		",\u0001-\u0001-\u0005-\u0104\b-\n-\f-\u0107\t-\u0001.\u0001.\u0001.\u0001"+
		".\u0005.\u010d\b.\n.\f.\u0110\t.\u0001.\u0001.\u0001.\u0001.\u0001.\u0005"+
		".\u0117\b.\n.\f.\u011a\t.\u0001.\u0003.\u011d\b.\u0001/\u0004/\u0120\b"+
		"/\u000b/\f/\u0121\u0001/\u0001/\u0004/\u0126\b/\u000b/\f/\u0127\u0003"+
		"/\u012a\b/\u0001/\u0001/\u0003/\u012e\b/\u0001/\u0004/\u0131\b/\u000b"+
		"/\f/\u0132\u0003/\u0135\b/\u0000\u00000\u0001\u0003\u0003\u0000\u0005"+
		"\u0004\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013\u000b"+
		"\u0015\f\u0017\r\u0019\u000e\u001b\u000f\u001d\u0010\u001f\u0011!\u0012"+
		"#\u0013%\u0014\'\u0015)\u0016+\u0017-\u0018/\u00191\u001a3\u001b5\u001c"+
		"7\u001d9\u001e;\u001f= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]0_1\u0001\u0000"+
		"\t\u0003\u0000\t\t  \u00a0\u00a0\u0002\u0000\n\n\r\r\u0003\u0000AZ__a"+
		"z\u0004\u000009AZ__az\u0004\u0000\n\n\r\r\"\"\\\\\u0004\u0000\n\n\r\r"+
		"\'\'\\\\\u0001\u000009\u0002\u0000EEee\u0002\u0000++--\u0144\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000"+
		"E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001"+
		"\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000"+
		"\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000"+
		"S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001"+
		"\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000"+
		"\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0001"+
		"e\u0001\u0000\u0000\u0000\u0003i\u0001\u0000\u0000\u0000\u0005l\u0001"+
		"\u0000\u0000\u0000\u0007r\u0001\u0000\u0000\u0000\t{\u0001\u0000\u0000"+
		"\u0000\u000b\u007f\u0001\u0000\u0000\u0000\r\u0082\u0001\u0000\u0000\u0000"+
		"\u000f\u0087\u0001\u0000\u0000\u0000\u0011\u008c\u0001\u0000\u0000\u0000"+
		"\u0013\u0093\u0001\u0000\u0000\u0000\u0015\u0097\u0001\u0000\u0000\u0000"+
		"\u0017\u009a\u0001\u0000\u0000\u0000\u0019\u009f\u0001\u0000\u0000\u0000"+
		"\u001b\u00a6\u0001\u0000\u0000\u0000\u001d\u00ab\u0001\u0000\u0000\u0000"+
		"\u001f\u00b0\u0001\u0000\u0000\u0000!\u00b6\u0001\u0000\u0000\u0000#\u00bb"+
		"\u0001\u0000\u0000\u0000%\u00be\u0001\u0000\u0000\u0000\'\u00c2\u0001"+
		"\u0000\u0000\u0000)\u00c5\u0001\u0000\u0000\u0000+\u00c9\u0001\u0000\u0000"+
		"\u0000-\u00cf\u0001\u0000\u0000\u0000/\u00d2\u0001\u0000\u0000\u00001"+
		"\u00d5\u0001\u0000\u0000\u00003\u00d8\u0001\u0000\u0000\u00005\u00db\u0001"+
		"\u0000\u0000\u00007\u00dd\u0001\u0000\u0000\u00009\u00df\u0001\u0000\u0000"+
		"\u0000;\u00e1\u0001\u0000\u0000\u0000=\u00e3\u0001\u0000\u0000\u0000?"+
		"\u00e5\u0001\u0000\u0000\u0000A\u00e7\u0001\u0000\u0000\u0000C\u00e9\u0001"+
		"\u0000\u0000\u0000E\u00eb\u0001\u0000\u0000\u0000G\u00ed\u0001\u0000\u0000"+
		"\u0000I\u00ef\u0001\u0000\u0000\u0000K\u00f1\u0001\u0000\u0000\u0000M"+
		"\u00f3\u0001\u0000\u0000\u0000O\u00f5\u0001\u0000\u0000\u0000Q\u00f7\u0001"+
		"\u0000\u0000\u0000S\u00f9\u0001\u0000\u0000\u0000U\u00fb\u0001\u0000\u0000"+
		"\u0000W\u00fd\u0001\u0000\u0000\u0000Y\u00ff\u0001\u0000\u0000\u0000["+
		"\u0101\u0001\u0000\u0000\u0000]\u011c\u0001\u0000\u0000\u0000_\u011f\u0001"+
		"\u0000\u0000\u0000ac\u0005\r\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0005\n\u0000\u0000eb\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000h\u0002\u0001\u0000\u0000\u0000ij\u0007\u0000"+
		"\u0000\u0000j\u0004\u0001\u0000\u0000\u0000km\u0003\u0003\u0001\u0000"+
		"lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0006\u0002"+
		"\u0000\u0000q\u0006\u0001\u0000\u0000\u0000rv\u0005#\u0000\u0000su\b\u0001"+
		"\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000yz\u0006\u0003\u0000\u0000z\b\u0001\u0000\u0000"+
		"\u0000{|\u0005d\u0000\u0000|}\u0005e\u0000\u0000}~\u0005f\u0000\u0000"+
		"~\n\u0001\u0000\u0000\u0000\u007f\u0080\u0005i\u0000\u0000\u0080\u0081"+
		"\u0005f\u0000\u0000\u0081\f\u0001\u0000\u0000\u0000\u0082\u0083\u0005"+
		"e\u0000\u0000\u0083\u0084\u0005l\u0000\u0000\u0084\u0085\u0005i\u0000"+
		"\u0000\u0085\u0086\u0005f\u0000\u0000\u0086\u000e\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005e\u0000\u0000\u0088\u0089\u0005l\u0000\u0000\u0089\u008a"+
		"\u0005s\u0000\u0000\u008a\u008b\u0005e\u0000\u0000\u008b\u0010\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005r\u0000\u0000\u008d\u008e\u0005e\u0000\u0000"+
		"\u008e\u008f\u0005t\u0000\u0000\u008f\u0090\u0005u\u0000\u0000\u0090\u0091"+
		"\u0005r\u0000\u0000\u0091\u0092\u0005n\u0000\u0000\u0092\u0012\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005f\u0000\u0000\u0094\u0095\u0005o\u0000\u0000"+
		"\u0095\u0096\u0005r\u0000\u0000\u0096\u0014\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005i\u0000\u0000\u0098\u0099\u0005n\u0000\u0000\u0099\u0016\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005f\u0000\u0000\u009b\u009c\u0005r\u0000"+
		"\u0000\u009c\u009d\u0005o\u0000\u0000\u009d\u009e\u0005m\u0000\u0000\u009e"+
		"\u0018\u0001\u0000\u0000\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0\u00a1"+
		"\u0005m\u0000\u0000\u00a1\u00a2\u0005p\u0000\u0000\u00a2\u00a3\u0005o"+
		"\u0000\u0000\u00a3\u00a4\u0005r\u0000\u0000\u00a4\u00a5\u0005t\u0000\u0000"+
		"\u00a5\u001a\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005N\u0000\u0000\u00a7"+
		"\u00a8\u0005o\u0000\u0000\u00a8\u00a9\u0005n\u0000\u0000\u00a9\u00aa\u0005"+
		"e\u0000\u0000\u00aa\u001c\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005T\u0000"+
		"\u0000\u00ac\u00ad\u0005r\u0000\u0000\u00ad\u00ae\u0005u\u0000\u0000\u00ae"+
		"\u00af\u0005e\u0000\u0000\u00af\u001e\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005F\u0000\u0000\u00b1\u00b2\u0005a\u0000\u0000\u00b2\u00b3\u0005l"+
		"\u0000\u0000\u00b3\u00b4\u0005s\u0000\u0000\u00b4\u00b5\u0005e\u0000\u0000"+
		"\u00b5 \u0001\u0000\u0000\u0000\u00b6\u00b7\u0005w\u0000\u0000\u00b7\u00b8"+
		"\u0005i\u0000\u0000\u00b8\u00b9\u0005t\u0000\u0000\u00b9\u00ba\u0005h"+
		"\u0000\u0000\u00ba\"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005a\u0000"+
		"\u0000\u00bc\u00bd\u0005s\u0000\u0000\u00bd$\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0005a\u0000\u0000\u00bf\u00c0\u0005n\u0000\u0000\u00c0\u00c1\u0005"+
		"d\u0000\u0000\u00c1&\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005o\u0000"+
		"\u0000\u00c3\u00c4\u0005r\u0000\u0000\u00c4(\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005n\u0000\u0000\u00c6\u00c7\u0005o\u0000\u0000\u00c7\u00c8\u0005"+
		"t\u0000\u0000\u00c8*\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005r\u0000"+
		"\u0000\u00ca\u00cb\u0005o\u0000\u0000\u00cb\u00cc\u0005u\u0000\u0000\u00cc"+
		"\u00cd\u0005t\u0000\u0000\u00cd\u00ce\u0005e\u0000\u0000\u00ce,\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005=\u0000\u0000\u00d0\u00d1\u0005=\u0000"+
		"\u0000\u00d1.\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005!\u0000\u0000\u00d3"+
		"\u00d4\u0005=\u0000\u0000\u00d40\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005"+
		"<\u0000\u0000\u00d6\u00d7\u0005=\u0000\u0000\u00d72\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005>\u0000\u0000\u00d9\u00da\u0005=\u0000\u0000\u00da"+
		"4\u0001\u0000\u0000\u0000\u00db\u00dc\u0005<\u0000\u0000\u00dc6\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0005>\u0000\u0000\u00de8\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005+\u0000\u0000\u00e0:\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0005-\u0000\u0000\u00e2<\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"*\u0000\u0000\u00e4>\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005/\u0000"+
		"\u0000\u00e6@\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005%\u0000\u0000\u00e8"+
		"B\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005=\u0000\u0000\u00eaD\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005@\u0000\u0000\u00ecF\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0005.\u0000\u0000\u00eeH\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0005(\u0000\u0000\u00f0J\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005"+
		")\u0000\u0000\u00f2L\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005[\u0000"+
		"\u0000\u00f4N\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005]\u0000\u0000\u00f6"+
		"P\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005{\u0000\u0000\u00f8R\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0005}\u0000\u0000\u00faT\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0005,\u0000\u0000\u00fcV\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0005:\u0000\u0000\u00feX\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		";\u0000\u0000\u0100Z\u0001\u0000\u0000\u0000\u0101\u0105\u0007\u0002\u0000"+
		"\u0000\u0102\u0104\u0007\u0003\u0000\u0000\u0103\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\\\u0001\u0000\u0000\u0000"+
		"\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010e\u0005\"\u0000\u0000\u0109"+
		"\u010d\b\u0004\u0000\u0000\u010a\u010b\u0005\\\u0000\u0000\u010b\u010d"+
		"\t\u0000\u0000\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010c\u010a\u0001"+
		"\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0111\u0001"+
		"\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u011d\u0005"+
		"\"\u0000\u0000\u0112\u0118\u0005\'\u0000\u0000\u0113\u0117\b\u0005\u0000"+
		"\u0000\u0114\u0115\u0005\\\u0000\u0000\u0115\u0117\t\u0000\u0000\u0000"+
		"\u0116\u0113\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000"+
		"\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011b\u0001\u0000\u0000\u0000"+
		"\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011d\u0005\'\u0000\u0000\u011c"+
		"\u0108\u0001\u0000\u0000\u0000\u011c\u0112\u0001\u0000\u0000\u0000\u011d"+
		"^\u0001\u0000\u0000\u0000\u011e\u0120\u0007\u0006\u0000\u0000\u011f\u011e"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u011f"+
		"\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0129"+
		"\u0001\u0000\u0000\u0000\u0123\u0125\u0005.\u0000\u0000\u0124\u0126\u0007"+
		"\u0006\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001"+
		"\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001"+
		"\u0000\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0123\u0001"+
		"\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u0134\u0001"+
		"\u0000\u0000\u0000\u012b\u012d\u0007\u0007\u0000\u0000\u012c\u012e\u0007"+
		"\b\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000"+
		"\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u0131\u0007\u0006"+
		"\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"+
		"\u0000\u0000\u0133\u0135\u0001\u0000\u0000\u0000\u0134\u012b\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135`\u0001\u0000\u0000"+
		"\u0000\u0011\u0000bgnv\u0105\u010c\u010e\u0116\u0118\u011c\u0121\u0127"+
		"\u0129\u012d\u0132\u0134\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}