// Generated from StreamQl.g4 by ANTLR 4.2.2

    package deephacks.streamql;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StreamQlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, STRING=9,
		NUMBER=10, DECIMAL=11, NULL=12, TRUE=13, FALSE=14, AND=15, OR=16, NOT=17,
		EQ=18, NT_EQ=19, LT_EQ=20, GT_EQ=21, GT=22, LT=23, CONTAINS=24, STARTS_WITH=25,
		ENDS_WITH=26, REGEXP=27, ID=28, WS=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'ordered'", "'reversed'", "'limit'", "'('", "'filter'",
		"')'", "','", "'skip'", "STRING", "NUMBER", "DECIMAL", "'null'", "'true'",
		"'false'", "'&&'", "'||'", "'!'", "'=='", "'!='", "'<='", "'>='", "'>'",
		"'<'", "'contains'", "'startsWith'", "'endsWith'", "'regExp'", "ID", "WS"
	};
	public static final int
		RULE_parse = 0, RULE_expression = 1, RULE_or = 2, RULE_and = 3, RULE_not = 4,
		RULE_limit = 5, RULE_skip = 6, RULE_ordering = 7, RULE_ordered = 8, RULE_reversed = 9,
		RULE_filter = 10, RULE_value = 11, RULE_operator = 12;
	public static final String[] ruleNames = {
		"parse", "expression", "or", "and", "not", "limit", "skip", "ordering",
		"ordered", "reversed", "filter", "value", "operator"
	};

	@Override
	public String getGrammarFileName() { return "StreamQl.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StreamQlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StreamQlParser.ID, 0); }
		public SkipContext skip() {
			return getRuleContext(SkipContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public OrderingContext ordering() {
			return getRuleContext(OrderingContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(28); match(ID);
					}
				}

				setState(33);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(31); match(5);
					setState(32); or();
					}
				}

				setState(37);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(35); match(8);
					setState(36); skip();
					}
				}

				setState(41);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(39); match(3);
					setState(40); limit();
					}
				}

				setState(44);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(43); ordering();
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(46); match(ID);
					}
				}

				setState(51);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(49); match(5);
					setState(50); or();
					}
				}

				setState(55);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(53); match(3);
					setState(54); limit();
					}
				}

				setState(59);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(57); match(8);
					setState(58); skip();
					}
				}

				setState(62);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(61); ordering();
					}
					break;
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(64); match(ID);
					}
				}

				setState(69);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(67); match(5);
					setState(68); or();
					}
				}

				setState(72);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(71); ordering();
					}
					break;
				}
				setState(76);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(74); match(3);
					setState(75); limit();
					}
				}

				setState(80);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(78); match(8);
					setState(79); skip();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(82); match(ID);
					}
				}

				setState(87);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(85); match(5);
					setState(86); or();
					}
				}

				setState(90);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(89); ordering();
					}
					break;
				}
				setState(94);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(92); match(8);
					setState(93); skip();
					}
				}

				setState(98);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(96); match(3);
					setState(97); limit();
					}
				}

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

	public static class OrContext extends ParserRuleContext {
		public List<TerminalNode> OR() { return getTokens(StreamQlParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(StreamQlParser.OR, i);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); and();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(103); match(OR);
				setState(104); and();
				}
				}
				setState(109);
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

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND(int i) {
			return getToken(StreamQlParser.AND, i);
		}
		public NotContext not(int i) {
			return getRuleContext(NotContext.class,i);
		}
		public List<NotContext> not() {
			return getRuleContexts(NotContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(StreamQlParser.AND); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); not();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(111); match(AND);
				setState(112); not();
				}
				}
				setState(117);
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

	public static class NotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(StreamQlParser.NOT, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_not);
		try {
			setState(121);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(118); match(NOT);
				setState(119); filter();
				}
				break;
			case 4:
			case EQ:
			case NT_EQ:
			case LT_EQ:
			case GT_EQ:
			case GT:
			case LT:
			case CONTAINS:
			case STARTS_WITH:
			case ENDS_WITH:
			case REGEXP:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); filter();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode NUMBER(int i) {
			return getToken(StreamQlParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(StreamQlParser.NUMBER); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitLimit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_limit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(NUMBER);
			setState(126);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(124); match(7);
				setState(125); match(NUMBER);
				}
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

	public static class SkipContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(StreamQlParser.NUMBER, 0); }
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(NUMBER);
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

	public static class OrderingContext extends ParserRuleContext {
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public OrderedContext ordered() {
			return getRuleContext(OrderedContext.class,0);
		}
		public OrderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitOrdering(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderingContext ordering() throws RecognitionException {
		OrderingContext _localctx = new OrderingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ordering);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			switch (_input.LA(1)) {
			case 1:
				{
				{
				setState(130); match(1);
				setState(131); ordered();
				}
				}
				break;
			case 2:
				{
				{
				setState(132); match(2);
				setState(133); reversed();
				}
				}
				break;
			case EOF:
			case 3:
			case 8:
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class OrderedContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(StreamQlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StreamQlParser.ID, i);
		}
		public OrderedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordered; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitOrdered(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderedContext ordered() throws RecognitionException {
		OrderedContext _localctx = new OrderedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ordered);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(136); match(ID);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==7) {
					{
					{
					setState(137); match(7);
					setState(138); match(ID);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ReversedContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(StreamQlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(StreamQlParser.ID, i);
		}
		public ReversedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reversed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitReversed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReversedContext reversed() throws RecognitionException {
		ReversedContext _localctx = new ReversedContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_reversed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(146); match(ID);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==7) {
					{
					{
					setState(147); match(7);
					setState(148); match(ID);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class FilterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(StreamQlParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_filter);
		int _la;
		try {
			setState(166);
			switch (_input.LA(1)) {
			case EQ:
			case NT_EQ:
			case LT_EQ:
			case GT_EQ:
			case GT:
			case LT:
			case CONTAINS:
			case STARTS_WITH:
			case ENDS_WITH:
			case REGEXP:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(156); match(ID);
					}
				}

				setState(159); operator();
				setState(160); value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(162); match(4);
				setState(163); or();
				setState(164); match(6);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(StreamQlParser.DECIMAL, 0); }
		public TerminalNode NULL() { return getToken(StreamQlParser.NULL, 0); }
		public TerminalNode FALSE() { return getToken(StreamQlParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(StreamQlParser.TRUE, 0); }
		public TerminalNode STRING() { return getToken(StreamQlParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(StreamQlParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << NUMBER) | (1L << DECIMAL) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode CONTAINS() { return getToken(StreamQlParser.CONTAINS, 0); }
		public TerminalNode LT_EQ() { return getToken(StreamQlParser.LT_EQ, 0); }
		public TerminalNode LT() { return getToken(StreamQlParser.LT, 0); }
		public TerminalNode GT() { return getToken(StreamQlParser.GT, 0); }
		public TerminalNode EQ() { return getToken(StreamQlParser.EQ, 0); }
		public TerminalNode STARTS_WITH() { return getToken(StreamQlParser.STARTS_WITH, 0); }
		public TerminalNode ENDS_WITH() { return getToken(StreamQlParser.ENDS_WITH, 0); }
		public TerminalNode NT_EQ() { return getToken(StreamQlParser.NT_EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(StreamQlParser.GT_EQ, 0); }
		public TerminalNode REGEXP() { return getToken(StreamQlParser.REGEXP, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StreamQlVisitor ) return ((StreamQlVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NT_EQ) | (1L << LT_EQ) | (1L << GT_EQ) | (1L << GT) | (1L << LT) | (1L << CONTAINS) | (1L << STARTS_WITH) | (1L << ENDS_WITH) | (1L << REGEXP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00af\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\5\3 \n\3\3\3\3\3\5\3$\n\3"+
		"\3\3\3\3\5\3(\n\3\3\3\3\3\5\3,\n\3\3\3\5\3/\n\3\3\3\5\3\62\n\3\3\3\3\3"+
		"\5\3\66\n\3\3\3\3\3\5\3:\n\3\3\3\3\3\5\3>\n\3\3\3\5\3A\n\3\3\3\5\3D\n"+
		"\3\3\3\3\3\5\3H\n\3\3\3\5\3K\n\3\3\3\3\3\5\3O\n\3\3\3\3\3\5\3S\n\3\3\3"+
		"\5\3V\n\3\3\3\3\3\5\3Z\n\3\3\3\5\3]\n\3\3\3\3\3\5\3a\n\3\3\3\3\3\5\3e"+
		"\n\3\5\3g\n\3\3\4\3\4\3\4\7\4l\n\4\f\4\16\4o\13\4\3\5\3\5\3\5\7\5t\n\5"+
		"\f\5\16\5w\13\5\3\6\3\6\3\6\5\6|\n\6\3\7\3\7\3\7\5\7\u0081\n\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\7\n\u008e\n\n\f\n\16\n\u0091"+
		"\13\n\5\n\u0093\n\n\3\13\3\13\3\13\7\13\u0098\n\13\f\13\16\13\u009b\13"+
		"\13\5\13\u009d\n\13\3\f\5\f\u00a0\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00a9\n\f\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\2\4\3\2\13\20\3\2\24\35\u00c4\2\34\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\b"+
		"p\3\2\2\2\n{\3\2\2\2\f}\3\2\2\2\16\u0082\3\2\2\2\20\u0088\3\2\2\2\22\u0092"+
		"\3\2\2\2\24\u009c\3\2\2\2\26\u00a8\3\2\2\2\30\u00aa\3\2\2\2\32\u00ac\3"+
		"\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36 \7\36\2\2\37\36\3\2\2\2\37 \3\2\2"+
		"\2 #\3\2\2\2!\"\7\7\2\2\"$\5\6\4\2#!\3\2\2\2#$\3\2\2\2$\'\3\2\2\2%&\7"+
		"\n\2\2&(\5\16\b\2\'%\3\2\2\2\'(\3\2\2\2(+\3\2\2\2)*\7\5\2\2*,\5\f\7\2"+
		"+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\20\t\2.-\3\2\2\2./\3\2\2\2/g\3\2\2"+
		"\2\60\62\7\36\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\64\7\7"+
		"\2\2\64\66\5\6\4\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\678\7\5\2\2"+
		"8:\5\f\7\29\67\3\2\2\29:\3\2\2\2:=\3\2\2\2;<\7\n\2\2<>\5\16\b\2=;\3\2"+
		"\2\2=>\3\2\2\2>@\3\2\2\2?A\5\20\t\2@?\3\2\2\2@A\3\2\2\2Ag\3\2\2\2BD\7"+
		"\36\2\2CB\3\2\2\2CD\3\2\2\2DG\3\2\2\2EF\7\7\2\2FH\5\6\4\2GE\3\2\2\2GH"+
		"\3\2\2\2HJ\3\2\2\2IK\5\20\t\2JI\3\2\2\2JK\3\2\2\2KN\3\2\2\2LM\7\5\2\2"+
		"MO\5\f\7\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PQ\7\n\2\2QS\5\16\b\2RP\3\2\2"+
		"\2RS\3\2\2\2Sg\3\2\2\2TV\7\36\2\2UT\3\2\2\2UV\3\2\2\2VY\3\2\2\2WX\7\7"+
		"\2\2XZ\5\6\4\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\5\20\t\2\\[\3\2\2\2\\"+
		"]\3\2\2\2]`\3\2\2\2^_\7\n\2\2_a\5\16\b\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2"+
		"bc\7\5\2\2ce\5\f\7\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2f\37\3\2\2\2f\61\3\2"+
		"\2\2fC\3\2\2\2fU\3\2\2\2g\5\3\2\2\2hm\5\b\5\2ij\7\22\2\2jl\5\b\5\2ki\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\7\3\2\2\2om\3\2\2\2pu\5\n\6\2qr"+
		"\7\21\2\2rt\5\n\6\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\t\3\2\2\2"+
		"wu\3\2\2\2xy\7\23\2\2y|\5\26\f\2z|\5\26\f\2{x\3\2\2\2{z\3\2\2\2|\13\3"+
		"\2\2\2}\u0080\7\f\2\2~\177\7\t\2\2\177\u0081\7\f\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\7\f\2\2\u0083\17\3\2\2\2\u0084"+
		"\u0085\7\3\2\2\u0085\u0089\5\22\n\2\u0086\u0087\7\4\2\2\u0087\u0089\5"+
		"\24\13\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\21\3\2\2\2\u008a\u008f\7\36\2\2\u008b\u008c\7\t\2\2\u008c\u008e\7\36"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u008a\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\23\3\2\2\2\u0094\u0099\7\36\2\2\u0095\u0096"+
		"\7\t\2\2\u0096\u0098\7\36\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2"+
		"\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u009d\3\2\2\2\u009d\25\3\2\2\2\u009e"+
		"\u00a0\7\36\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3"+
		"\2\2\2\u00a1\u00a2\5\32\16\2\u00a2\u00a3\5\30\r\2\u00a3\u00a9\3\2\2\2"+
		"\u00a4\u00a5\7\6\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\7\b\2\2\u00a7\u00a9"+
		"\3\2\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a9\27\3\2\2\2\u00aa"+
		"\u00ab\t\2\2\2\u00ab\31\3\2\2\2\u00ac\u00ad\t\3\2\2\u00ad\33\3\2\2\2\""+
		"\37#\'+.\61\659=@CGJNRUY\\`dfmu{\u0080\u0088\u008f\u0092\u0099\u009c\u009f"+
		"\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}