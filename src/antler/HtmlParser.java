// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/HtmlParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HtmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOCTYPE=1, FOR=2, ENDFOR=3, IF=4, ENDIF=5, IN=6, LBRACE_PERCENT=7, RBRACE_PERCENT=8, 
		LBRACE_DOUBLE=9, RBRACE_DOUBLE=10, OPEN_TAG_SLASH=11, OPEN_TAG=12, CLOSE_TAG=13, 
		SLASH_CLOSE=14, EQUALS=15, LBRACE=16, RBRACE=17, COLON=18, SEMICOLON=19, 
		LBRACE_Q=20, DOT=21, DASH=22, SLASH=23, IDENTIFIER=24, STRING=25, NUMBER=26, 
		DIMENSION=27, ANY_SYMBOL=28, WS=29, HTML_COMMENT=30, EMOJI=31;
	public static final int
		RULE_htmlNode = 0, RULE_htmlElement = 1, RULE_htmlTag = 2, RULE_htmlPairTag = 3, 
		RULE_htmlSingleTag = 4, RULE_tagName = 5, RULE_htmlAttribute = 6, RULE_attributeKey = 7, 
		RULE_attributeValue = 8, RULE_htmlContent = 9, RULE_dottedName = 10, RULE_cssClass = 11, 
		RULE_cssDeclaration = 12, RULE_cssKey = 13, RULE_cssValue = 14, RULE_jinjaStatement = 15, 
		RULE_jinjaExpression = 16, RULE_forBlock = 17, RULE_ifBlock = 18, RULE_text = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlNode", "htmlElement", "htmlTag", "htmlPairTag", "htmlSingleTag", 
			"tagName", "htmlAttribute", "attributeKey", "attributeValue", "htmlContent", 
			"dottedName", "cssClass", "cssDeclaration", "cssKey", "cssValue", "jinjaStatement", 
			"jinjaExpression", "forBlock", "ifBlock", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'for'", "'endfor'", "'if'", "'endif'", "'in'", "'{%'", "'%}'", 
			"'{{'", "'}}'", "'</'", "'<'", "'>'", "'/>'", "'='", "'{'", "'}'", "':'", 
			"';'", "'\"'", "'.'", "'-'", "'/'", null, null, null, null, null, null, 
			"'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "FOR", "ENDFOR", "IF", "ENDIF", "IN", "LBRACE_PERCENT", 
			"RBRACE_PERCENT", "LBRACE_DOUBLE", "RBRACE_DOUBLE", "OPEN_TAG_SLASH", 
			"OPEN_TAG", "CLOSE_TAG", "SLASH_CLOSE", "EQUALS", "LBRACE", "RBRACE", 
			"COLON", "SEMICOLON", "LBRACE_Q", "DOT", "DASH", "SLASH", "IDENTIFIER", 
			"STRING", "NUMBER", "DIMENSION", "ANY_SYMBOL", "WS", "HTML_COMMENT", 
			"EMOJI"
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

	@Override
	public String getGrammarFileName() { return "HtmlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HtmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlNodeContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HtmlParser.EOF, 0); }
		public TerminalNode DOCTYPE() { return getToken(HtmlParser.DOCTYPE, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public HtmlNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlNodeContext htmlNode() throws RecognitionException {
		HtmlNodeContext _localctx = new HtmlNodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(40);
				match(DOCTYPE);
				}
			}

			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 367825536L) != 0)) {
				{
				{
				setState(43);
				htmlContent();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlTagContext htmlTag() {
			return getRuleContext(HtmlTagContext.class,0);
		}
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			htmlTag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTagContext extends ParserRuleContext {
		public HtmlTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlTag; }
	 
		public HtmlTagContext() { }
		public void copyFrom(HtmlTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSingleTagExpContext extends HtmlTagContext {
		public HtmlSingleTagContext htmlSingleTag() {
			return getRuleContext(HtmlSingleTagContext.class,0);
		}
		public HtmlSingleTagExpContext(HtmlTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlSingleTagExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlSingleTagExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlSingleTagExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlPairTagExpContext extends HtmlTagContext {
		public HtmlPairTagContext htmlPairTag() {
			return getRuleContext(HtmlPairTagContext.class,0);
		}
		public HtmlPairTagExpContext(HtmlTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlPairTagExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlPairTagExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlPairTagExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlTagContext htmlTag() throws RecognitionException {
		HtmlTagContext _localctx = new HtmlTagContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlTag);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlPairTagExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				htmlPairTag();
				}
				break;
			case 2:
				_localctx = new HtmlSingleTagExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				htmlSingleTag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlPairTagContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(HtmlParser.OPEN_TAG, 0); }
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public List<TerminalNode> CLOSE_TAG() { return getTokens(HtmlParser.CLOSE_TAG); }
		public TerminalNode CLOSE_TAG(int i) {
			return getToken(HtmlParser.CLOSE_TAG, i);
		}
		public TerminalNode OPEN_TAG_SLASH() { return getToken(HtmlParser.OPEN_TAG_SLASH, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public HtmlPairTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlPairTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlPairTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlPairTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlPairTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlPairTagContext htmlPairTag() throws RecognitionException {
		HtmlPairTagContext _localctx = new HtmlPairTagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlPairTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(OPEN_TAG);
			setState(58);
			tagName();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(59);
				htmlAttribute();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(CLOSE_TAG);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 367825536L) != 0)) {
				{
				{
				setState(66);
				htmlContent();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(OPEN_TAG_SLASH);
			setState(73);
			tagName();
			setState(74);
			match(CLOSE_TAG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSingleTagContext extends ParserRuleContext {
		public HtmlSingleTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlSingleTag; }
	 
		public HtmlSingleTagContext() { }
		public void copyFrom(HtmlSingleTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSingleTagSelfClosingContext extends HtmlSingleTagContext {
		public TerminalNode OPEN_TAG() { return getToken(HtmlParser.OPEN_TAG, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode SLASH_CLOSE() { return getToken(HtmlParser.SLASH_CLOSE, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public HtmlSingleTagSelfClosingContext(HtmlSingleTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlSingleTagSelfClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlSingleTagSelfClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlSingleTagSelfClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlSingleTagContext htmlSingleTag() throws RecognitionException {
		HtmlSingleTagContext _localctx = new HtmlSingleTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlSingleTag);
		int _la;
		try {
			_localctx = new HtmlSingleTagSelfClosingContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(OPEN_TAG);
			setState(77);
			tagName();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(78);
				htmlAttribute();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(SLASH_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends ParserRuleContext {
		public AttributeKeyContext attributeKey() {
			return getRuleContext(AttributeKeyContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(HtmlParser.EQUALS, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			attributeKey();
			setState(89);
			match(EQUALS);
			setState(90);
			attributeValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeKeyContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public AttributeKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttributeKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttributeKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttributeKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeKeyContext attributeKey() throws RecognitionException {
		AttributeKeyContext _localctx = new AttributeKeyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attributeKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HtmlParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(HtmlParser.NUMBER, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attributeValue);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
	 
		public HtmlContentContext() { }
		public void copyFrom(HtmlContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssClassExpressionContext extends HtmlContentContext {
		public List<CssClassContext> cssClass() {
			return getRuleContexts(CssClassContext.class);
		}
		public CssClassContext cssClass(int i) {
			return getRuleContext(CssClassContext.class,i);
		}
		public CssClassExpressionContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssClassExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssClassExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssClassExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementHtmlContext extends HtmlContentContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public ElementHtmlContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterElementHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitElementHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitElementHtml(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementJinjaContext extends HtmlContentContext {
		public JinjaStatementContext jinjaStatement() {
			return getRuleContext(JinjaStatementContext.class,0);
		}
		public StatementJinjaContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterStatementJinja(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitStatementJinja(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitStatementJinja(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionJinjaContext extends HtmlContentContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public ExpressionJinjaContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterExpressionJinja(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitExpressionJinja(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitExpressionJinja(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextExpressionContext extends HtmlContentContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TextExpressionContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterTextExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitTextExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitTextExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends HtmlContentContext {
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_htmlContent);
		try {
			int _alt;
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ElementHtmlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				htmlElement();
				}
				break;
			case 2:
				_localctx = new StatementJinjaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				jinjaStatement();
				}
				break;
			case 3:
				_localctx = new ExpressionJinjaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				jinjaExpression();
				}
				break;
			case 4:
				_localctx = new CssClassExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(104); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(103);
						cssClass();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(106); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				_localctx = new TextExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				text();
				}
				break;
			case 6:
				_localctx = new IdentifierExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DottedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(HtmlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HtmlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(HtmlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(HtmlParser.DOT, i);
		}
		public DottedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterDottedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitDottedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitDottedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedNameContext dottedName() throws RecognitionException {
		DottedNameContext _localctx = new DottedNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dottedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(IDENTIFIER);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(113);
				match(DOT);
				{
				setState(114);
				match(IDENTIFIER);
				}
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssClassContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(HtmlParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(HtmlParser.RBRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public TerminalNode DOT() { return getToken(HtmlParser.DOT, 0); }
		public CssClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssClassContext cssClass() throws RecognitionException {
		CssClassContext _localctx = new CssClassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(120);
				match(DOT);
				}
			}

			setState(123);
			match(IDENTIFIER);
			}
			setState(125);
			match(LBRACE);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(126);
				cssDeclaration();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public CssKeyContext cssKey() {
			return getRuleContext(CssKeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(HtmlParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(HtmlParser.SEMICOLON, 0); }
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			cssKey();
			setState(135);
			match(COLON);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				cssValue();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 534773760L) != 0) );
			setState(141);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssKeyContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(HtmlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HtmlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DASH() { return getTokens(HtmlParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(HtmlParser.DASH, i);
		}
		public CssKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssKeyContext cssKey() throws RecognitionException {
		CssKeyContext _localctx = new CssKeyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cssKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(IDENTIFIER);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DASH) {
				{
				{
				setState(144);
				match(DASH);
				setState(145);
				match(IDENTIFIER);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public TerminalNode DIMENSION() { return getToken(HtmlParser.DIMENSION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(HtmlParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(HtmlParser.STRING, 0); }
		public TerminalNode ANY_SYMBOL() { return getToken(HtmlParser.ANY_SYMBOL, 0); }
		public TerminalNode DOT() { return getToken(HtmlParser.DOT, 0); }
		public TerminalNode DASH() { return getToken(HtmlParser.DASH, 0); }
		public TerminalNode SLASH() { return getToken(HtmlParser.SLASH, 0); }
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 534773760L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContext extends ParserRuleContext {
		public JinjaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStatement; }
	 
		public JinjaStatementContext() { }
		public void copyFrom(JinjaStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends JinjaStatementContext {
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public IfStatementContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends JinjaStatementContext {
		public ForBlockContext forBlock() {
			return getRuleContext(ForBlockContext.class,0);
		}
		public ForStatementContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStatementContext jinjaStatement() throws RecognitionException {
		JinjaStatementContext _localctx = new JinjaStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jinjaStatement);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				forBlock();
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				ifBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACE_DOUBLE() { return getToken(HtmlParser.LBRACE_DOUBLE, 0); }
		public DottedNameContext dottedName() {
			return getRuleContext(DottedNameContext.class,0);
		}
		public TerminalNode RBRACE_DOUBLE() { return getToken(HtmlParser.RBRACE_DOUBLE, 0); }
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jinjaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(LBRACE_DOUBLE);
			setState(158);
			dottedName();
			setState(159);
			match(RBRACE_DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBlockContext extends ParserRuleContext {
		public List<TerminalNode> LBRACE_PERCENT() { return getTokens(HtmlParser.LBRACE_PERCENT); }
		public TerminalNode LBRACE_PERCENT(int i) {
			return getToken(HtmlParser.LBRACE_PERCENT, i);
		}
		public TerminalNode FOR() { return getToken(HtmlParser.FOR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(HtmlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HtmlParser.IDENTIFIER, i);
		}
		public TerminalNode IN() { return getToken(HtmlParser.IN, 0); }
		public List<TerminalNode> RBRACE_PERCENT() { return getTokens(HtmlParser.RBRACE_PERCENT); }
		public TerminalNode RBRACE_PERCENT(int i) {
			return getToken(HtmlParser.RBRACE_PERCENT, i);
		}
		public TerminalNode ENDFOR() { return getToken(HtmlParser.ENDFOR, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public ForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitForBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBlockContext forBlock() throws RecognitionException {
		ForBlockContext _localctx = new ForBlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(LBRACE_PERCENT);
			setState(162);
			match(FOR);
			setState(163);
			match(IDENTIFIER);
			setState(164);
			match(IN);
			setState(165);
			match(IDENTIFIER);
			setState(166);
			match(RBRACE_PERCENT);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					htmlContent();
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(173);
			match(LBRACE_PERCENT);
			setState(174);
			match(ENDFOR);
			setState(175);
			match(RBRACE_PERCENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public List<TerminalNode> LBRACE_PERCENT() { return getTokens(HtmlParser.LBRACE_PERCENT); }
		public TerminalNode LBRACE_PERCENT(int i) {
			return getToken(HtmlParser.LBRACE_PERCENT, i);
		}
		public TerminalNode IF() { return getToken(HtmlParser.IF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HtmlParser.IDENTIFIER, 0); }
		public List<TerminalNode> RBRACE_PERCENT() { return getTokens(HtmlParser.RBRACE_PERCENT); }
		public TerminalNode RBRACE_PERCENT(int i) {
			return getToken(HtmlParser.RBRACE_PERCENT, i);
		}
		public TerminalNode ENDIF() { return getToken(HtmlParser.ENDIF, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(LBRACE_PERCENT);
			setState(178);
			match(IF);
			setState(179);
			match(IDENTIFIER);
			setState(180);
			match(RBRACE_PERCENT);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					htmlContent();
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(187);
			match(LBRACE_PERCENT);
			setState(188);
			match(ENDIF);
			setState(189);
			match(RBRACE_PERCENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(HtmlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HtmlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(HtmlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(HtmlParser.NUMBER, i);
		}
		public List<TerminalNode> ANY_SYMBOL() { return getTokens(HtmlParser.ANY_SYMBOL); }
		public TerminalNode ANY_SYMBOL(int i) {
			return getToken(HtmlParser.ANY_SYMBOL, i);
		}
		public List<TerminalNode> DOT() { return getTokens(HtmlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(HtmlParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(HtmlParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(HtmlParser.DASH, i);
		}
		public List<TerminalNode> COLON() { return getTokens(HtmlParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(HtmlParser.COLON, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(HtmlParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(HtmlParser.SEMICOLON, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(HtmlParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(HtmlParser.SLASH, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(HtmlParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(HtmlParser.EQUALS, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(191);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 367820800L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(194); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00c5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0003\u0000*\b\u0000\u0001"+
		"\u0000\u0005\u0000-\b\u0000\n\u0000\f\u00000\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u00028\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003=\b\u0003\n\u0003"+
		"\f\u0003@\t\u0003\u0001\u0003\u0001\u0003\u0005\u0003D\b\u0003\n\u0003"+
		"\f\u0003G\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004\n\u0004\f\u0004S\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\bc\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t"+
		"i\b\t\u000b\t\f\tj\u0001\t\u0001\t\u0003\to\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0005\nt\b\n\n\n\f\nw\t\n\u0001\u000b\u0003\u000bz\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0080\b\u000b\n\u000b"+
		"\f\u000b\u0083\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0004\f\u008a\b\f\u000b\f\f\f\u008b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0093\b\r\n\r\f\r\u0096\t\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u009c\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00a9\b\u0011\n\u0011\f\u0011\u00ac"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b7\b\u0012\n"+
		"\u0012\f\u0012\u00ba\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0004\u0013\u00c1\b\u0013\u000b\u0013\f\u0013\u00c2"+
		"\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0002\u0001\u0000"+
		"\u0015\u001c\u0005\u0000\u000f\u000f\u0012\u0013\u0015\u0018\u001a\u001a"+
		"\u001c\u001c\u00c8\u0000)\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000"+
		"\u0000\u00047\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\b"+
		"L\u0001\u0000\u0000\u0000\nV\u0001\u0000\u0000\u0000\fX\u0001\u0000\u0000"+
		"\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010b\u0001\u0000\u0000\u0000"+
		"\u0012n\u0001\u0000\u0000\u0000\u0014p\u0001\u0000\u0000\u0000\u0016y"+
		"\u0001\u0000\u0000\u0000\u0018\u0086\u0001\u0000\u0000\u0000\u001a\u008f"+
		"\u0001\u0000\u0000\u0000\u001c\u0097\u0001\u0000\u0000\u0000\u001e\u009b"+
		"\u0001\u0000\u0000\u0000 \u009d\u0001\u0000\u0000\u0000\"\u00a1\u0001"+
		"\u0000\u0000\u0000$\u00b1\u0001\u0000\u0000\u0000&\u00c0\u0001\u0000\u0000"+
		"\u0000(*\u0005\u0001\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000"+
		"\u0000\u0000*.\u0001\u0000\u0000\u0000+-\u0003\u0012\t\u0000,+\u0001\u0000"+
		"\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"12\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u000034\u0003\u0004"+
		"\u0002\u00004\u0003\u0001\u0000\u0000\u000058\u0003\u0006\u0003\u0000"+
		"68\u0003\b\u0004\u000075\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u0000"+
		"8\u0005\u0001\u0000\u0000\u00009:\u0005\f\u0000\u0000:>\u0003\n\u0005"+
		"\u0000;=\u0003\f\u0006\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000AE\u0005\r\u0000\u0000BD\u0003\u0012"+
		"\t\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000HI\u0005\u000b\u0000\u0000IJ\u0003\n\u0005\u0000JK\u0005"+
		"\r\u0000\u0000K\u0007\u0001\u0000\u0000\u0000LM\u0005\f\u0000\u0000MQ"+
		"\u0003\n\u0005\u0000NP\u0003\f\u0006\u0000ON\u0001\u0000\u0000\u0000P"+
		"S\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005\u000e"+
		"\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0005\u0018\u0000\u0000W\u000b"+
		"\u0001\u0000\u0000\u0000XY\u0003\u000e\u0007\u0000YZ\u0005\u000f\u0000"+
		"\u0000Z[\u0003\u0010\b\u0000[\r\u0001\u0000\u0000\u0000\\]\u0005\u0018"+
		"\u0000\u0000]\u000f\u0001\u0000\u0000\u0000^c\u0005\u0019\u0000\u0000"+
		"_c\u0005\u0018\u0000\u0000`c\u0005\u001a\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000b^\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000ba\u0001\u0000\u0000\u0000c\u0011\u0001\u0000\u0000\u0000"+
		"do\u0003\u0002\u0001\u0000eo\u0003\u001e\u000f\u0000fo\u0003 \u0010\u0000"+
		"gi\u0003\u0016\u000b\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ko\u0001\u0000"+
		"\u0000\u0000lo\u0003&\u0013\u0000mo\u0005\u0018\u0000\u0000nd\u0001\u0000"+
		"\u0000\u0000ne\u0001\u0000\u0000\u0000nf\u0001\u0000\u0000\u0000nh\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000"+
		"o\u0013\u0001\u0000\u0000\u0000pu\u0005\u0018\u0000\u0000qr\u0005\u0015"+
		"\u0000\u0000rt\u0005\u0018\u0000\u0000sq\u0001\u0000\u0000\u0000tw\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u0015\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0005\u0015"+
		"\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0005\u0018\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u0081\u0005\u0010\u0000\u0000~\u0080\u0003\u0018\f\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0084\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"\u0011\u0000\u0000\u0085\u0017\u0001\u0000\u0000\u0000\u0086\u0087\u0003"+
		"\u001a\r\u0000\u0087\u0089\u0005\u0012\u0000\u0000\u0088\u008a\u0003\u001c"+
		"\u000e\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0013"+
		"\u0000\u0000\u008e\u0019\u0001\u0000\u0000\u0000\u008f\u0094\u0005\u0018"+
		"\u0000\u0000\u0090\u0091\u0005\u0016\u0000\u0000\u0091\u0093\u0005\u0018"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u001b\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0007\u0000\u0000\u0000\u0098\u001d\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0003\"\u0011\u0000\u009a\u009c\u0003$\u0012"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u001f\u0001\u0000\u0000\u0000\u009d\u009e\u0005\t\u0000\u0000"+
		"\u009e\u009f\u0003\u0014\n\u0000\u009f\u00a0\u0005\n\u0000\u0000\u00a0"+
		"!\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0007\u0000\u0000\u00a2\u00a3"+
		"\u0005\u0002\u0000\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u00a5"+
		"\u0005\u0006\u0000\u0000\u00a5\u00a6\u0005\u0018\u0000\u0000\u00a6\u00aa"+
		"\u0005\b\u0000\u0000\u00a7\u00a9\u0003\u0012\t\u0000\u00a8\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005"+
		"\u0007\u0000\u0000\u00ae\u00af\u0005\u0003\u0000\u0000\u00af\u00b0\u0005"+
		"\b\u0000\u0000\u00b0#\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0007"+
		"\u0000\u0000\u00b2\u00b3\u0005\u0004\u0000\u0000\u00b3\u00b4\u0005\u0018"+
		"\u0000\u0000\u00b4\u00b8\u0005\b\u0000\u0000\u00b5\u00b7\u0003\u0012\t"+
		"\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005\u0007\u0000\u0000\u00bc\u00bd\u0005\u0005\u0000"+
		"\u0000\u00bd\u00be\u0005\b\u0000\u0000\u00be%\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0007\u0001\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\'\u0001\u0000\u0000\u0000\u0012"+
		").7>EQbjnuy\u0081\u008b\u0094\u009b\u00aa\u00b8\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}