// Generated from /home/kevin/Compi2/P2/OLC2_Proyecto2_201901801/GoLight/backend/Gramatica/Analizador.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnalizadorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, NEWLINE=44, COMENTARIO_LINEA=45, 
		COMENTARIO_MULTILINEA=46, INT=47, DECIMAL=48, BOOLEANO=49, CARACTER=50, 
		CADENA=51, ID=52, MODULO=53, IGUAL=54, DOSPUNTOS_IGUAL=55, PARENTESIS_ABRE=56, 
		PARENTESIS_CIERRA=57;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_sliceDcl = 2, RULE_forID = 3, RULE_caseList = 4, 
		RULE_caseStmt = 5, RULE_block = 6, RULE_varDcl = 7, RULE_varAsign = 8, 
		RULE_varCall = 9, RULE_parametros = 10, RULE_param = 11, RULE_args = 12, 
		RULE_expr = 13, RULE_tipo = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "sliceDcl", "forID", "caseList", "caseStmt", "block", 
			"varDcl", "varAsign", "varCall", "parametros", "param", "args", "expr", 
			"tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fmt.Println('", "','", "';'", "'if'", "'else'", "'for'", "'switch'", 
			"'{'", "'}'", "'func'", "'break'", "'continue'", "'return'", "'slice.Index'", 
			"'['", "']'", "'case'", "':'", "'default'", "'var'", "'!'", "'-'", "'++'", 
			"'--'", "'*'", "'/'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'+='", "'-='", "'&&'", "'||'", "'int'", "'float64'", "'string'", "'bool'", 
			"'rune'", "'void'", null, null, null, null, null, null, null, null, null, 
			"'%'", "'='", "':='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NEWLINE", "COMENTARIO_LINEA", 
			"COMENTARIO_MULTILINEA", "INT", "DECIMAL", "BOOLEANO", "CARACTER", "CADENA", 
			"ID", "MODULO", "IGUAL", "DOSPUNTOS_IGUAL", "PARENTESIS_ABRE", "PARENTESIS_CIERRA"
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
	public String getGrammarFileName() { return "Analizador.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnalizadorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055811718610L) != 0)) {
				{
				{
				setState(30);
				dcl();
				}
				}
				setState(35);
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
	public static class DclContext extends ParserRuleContext {
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	 
		public DclContext() { }
		public void copyFrom(DclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends DclContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CaseListContext caseList() {
			return getRuleContext(CaseListContext.class,0);
		}
		public SwitchStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends DclContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public PrintStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceIndexContext extends DclContext {
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public SliceIndexContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallStmtContext extends DclContext {
		public VarCallContext varCall() {
			return getRuleContext(VarCallContext.class,0);
		}
		public FuncCallStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends DclContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignStmtContext extends DclContext {
		public VarAsignContext varAsign() {
			return getRuleContext(VarAsignContext.class,0);
		}
		public AsignStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends DclContext {
		public ContinueStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends DclContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public IfStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends DclContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends DclContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public WhileStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends DclContext {
		public BreakStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclStmtContext extends DclContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public VarDeclStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclStmtContext extends DclContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public FuncDeclStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceAsignContext extends DclContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(AnalizadorParser.IGUAL, 0); }
		public SliceAsignContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends DclContext {
		public ForIDContext forID() {
			return getRuleContext(ForIDContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public ForStmtContext(DclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends DclContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(DclContext ctx) { copyFrom(ctx); }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		int _la;
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(T__0);
				setState(37);
				expr(0);
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(38);
					match(T__1);
					setState(39);
					expr(0);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(45);
				match(PARENTESIS_CIERRA);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(46);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(T__3);
				setState(50);
				expr(0);
				setState(51);
				block();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(52);
					match(T__4);
					setState(55);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(53);
						dcl();
						}
						break;
					case 2:
						{
						setState(54);
						block();
						}
						break;
					}
					}
				}

				}
				break;
			case 3:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__5);
				setState(61);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(60);
					match(PARENTESIS_ABRE);
					}
					break;
				}
				setState(63);
				expr(0);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARENTESIS_CIERRA) {
					{
					setState(64);
					match(PARENTESIS_CIERRA);
					}
				}

				setState(67);
				block();
				}
				break;
			case 4:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(T__5);
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(70);
					match(PARENTESIS_ABRE);
					}
					break;
				}
				setState(73);
				forID();
				setState(74);
				expr(0);
				setState(75);
				match(T__2);
				setState(76);
				expr(0);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARENTESIS_CIERRA) {
					{
					setState(77);
					match(PARENTESIS_CIERRA);
					}
				}

				setState(80);
				block();
				}
				break;
			case 5:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				match(T__6);
				setState(83);
				expr(0);
				setState(84);
				match(T__7);
				setState(85);
				caseList();
				setState(86);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new FuncDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(T__9);
				setState(89);
				match(ID);
				setState(90);
				match(PARENTESIS_ABRE);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(91);
					parametros();
					}
				}

				setState(94);
				match(PARENTESIS_CIERRA);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17317308137472L) != 0)) {
					{
					setState(95);
					tipo();
					}
				}

				setState(98);
				block();
				}
				break;
			case 7:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				match(T__10);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(100);
					match(T__2);
					}
				}

				}
				break;
			case 8:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				match(T__11);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(104);
					match(T__2);
					}
				}

				}
				break;
			case 9:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(107);
				match(T__12);
				setState(108);
				expr(0);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(109);
					match(T__2);
					}
				}

				}
				break;
			case 10:
				_localctx = new SliceIndexContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				match(T__13);
				setState(113);
				match(PARENTESIS_ABRE);
				setState(114);
				expr(0);
				setState(115);
				match(T__1);
				setState(116);
				expr(0);
				setState(117);
				match(PARENTESIS_CIERRA);
				}
				break;
			case 11:
				_localctx = new SliceAsignContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(119);
				match(ID);
				setState(120);
				match(T__14);
				setState(121);
				expr(0);
				setState(122);
				match(T__15);
				setState(123);
				match(IGUAL);
				setState(124);
				expr(0);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(125);
					match(T__2);
					}
				}

				}
				break;
			case 12:
				_localctx = new FuncCallStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(128);
				varCall();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(129);
					match(T__2);
					}
				}

				}
				break;
			case 13:
				_localctx = new AsignStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
				varAsign();
				}
				break;
			case 14:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(133);
				varDcl();
				}
				break;
			case 15:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(134);
				match(T__7);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055811718610L) != 0)) {
					{
					{
					setState(135);
					dcl();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(T__8);
				}
				break;
			case 16:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(142);
				expr(0);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(143);
					match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SliceDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TerminalNode DOSPUNTOS_IGUAL() { return getToken(AnalizadorParser.DOSPUNTOS_IGUAL, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceDcl; }
	}

	public final SliceDclContext sliceDcl() throws RecognitionException {
		SliceDclContext _localctx = new SliceDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sliceDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ID);
			setState(149);
			match(DOSPUNTOS_IGUAL);
			setState(150);
			match(T__14);
			setState(151);
			match(T__15);
			setState(152);
			tipo();
			setState(153);
			match(T__7);
			setState(154);
			expr(0);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(155);
				match(T__1);
				setState(156);
				expr(0);
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(T__8);
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(163);
				match(T__2);
				}
				break;
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
	public static class ForIDContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forID; }
	}

	public final ForIDContext forID() throws RecognitionException {
		ForIDContext _localctx = new ForIDContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forID);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				expr(0);
				setState(168);
				match(T__2);
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
	public static class CaseListContext extends ParserRuleContext {
		public List<CaseStmtContext> caseStmt() {
			return getRuleContexts(CaseStmtContext.class);
		}
		public CaseStmtContext caseStmt(int i) {
			return getRuleContext(CaseStmtContext.class,i);
		}
		public CaseListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseList; }
	}

	public final CaseListContext caseList() throws RecognitionException {
		CaseListContext _localctx = new CaseListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_caseList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				caseStmt();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__18 );
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
	public static class CaseStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public CaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStmt; }
	}

	public final CaseStmtContext caseStmt() throws RecognitionException {
		CaseStmtContext _localctx = new CaseStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_caseStmt);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(T__16);
				setState(178);
				expr(0);
				setState(179);
				match(T__17);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055811718610L) != 0)) {
					{
					{
					setState(180);
					dcl();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__18);
				setState(187);
				match(T__17);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055811718610L) != 0)) {
					{
					{
					setState(188);
					dcl();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__7);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055811718610L) != 0)) {
				{
				{
				setState(197);
				dcl();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(T__8);
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
	public static class VarDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(AnalizadorParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOSPUNTOS_IGUAL() { return getToken(AnalizadorParser.DOSPUNTOS_IGUAL, 0); }
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDcl);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(T__19);
				setState(206);
				match(ID);
				setState(207);
				tipo();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(208);
					match(IGUAL);
					setState(209);
					expr(0);
					}
				}

				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(212);
					match(T__2);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(ID);
				setState(216);
				match(DOSPUNTOS_IGUAL);
				setState(217);
				expr(0);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(218);
					match(T__2);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class VarAsignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(AnalizadorParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAsign; }
	}

	public final VarAsignContext varAsign() throws RecognitionException {
		VarAsignContext _localctx = new VarAsignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varAsign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(ID);
			setState(224);
			match(IGUAL);
			setState(225);
			expr(0);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(226);
				match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public VarCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varCall; }
	}

	public final VarCallContext varCall() throws RecognitionException {
		VarCallContext _localctx = new VarCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(ID);
			setState(230);
			match(PARENTESIS_ABRE);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 80924055810637824L) != 0)) {
				{
				setState(231);
				args();
				}
			}

			setState(234);
			match(PARENTESIS_CIERRA);
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			param();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(237);
				match(T__1);
				setState(238);
				param();
				}
				}
				setState(243);
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
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(ID);
			setState(245);
			tipo();
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
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			expr(0);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(248);
				match(T__1);
				setState(249);
				expr(0);
				}
				}
				setState(254);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CorchetesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CorchetesContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoDecrementoContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public IncrementoDecrementoContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceDeclStmtContext extends ExprContext {
		public SliceDclContext sliceDcl() {
			return getRuleContext(SliceDclContext.class,0);
		}
		public SliceDeclStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpCharContext extends ExprContext {
		public TerminalNode CARACTER() { return getToken(AnalizadorParser.CARACTER, 0); }
		public ExpCharContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpIntegerContext extends ExprContext {
		public TerminalNode INT() { return getToken(AnalizadorParser.INT, 0); }
		public ExpIntegerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccesoSliceContext extends ExprContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AccesoSliceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MODULO() { return getToken(AnalizadorParser.MODULO, 0); }
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsigAddSubContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(AnalizadorParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsigAddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpDoubleContext extends ExprContext {
		public TerminalNode DECIMAL() { return getToken(AnalizadorParser.DECIMAL, 0); }
		public ExpDoubleContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IgualDesigualContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IgualDesigualContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpBooleanContext extends ExprContext {
		public TerminalNode BOOLEANO() { return getToken(AnalizadorParser.BOOLEANO, 0); }
		public ExpBooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpStringContext extends ExprContext {
		public TerminalNode CADENA() { return getToken(AnalizadorParser.CADENA, 0); }
		public ExpStringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends ExprContext {
		public VarCallContext varCall() {
			return getRuleContext(VarCallContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(256);
				match(T__20);
				setState(257);
				expr(21);
				}
				break;
			case 2:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(T__21);
				setState(259);
				expr(20);
				}
				break;
			case 3:
				{
				_localctx = new IncrementoDecrementoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(ID);
				setState(261);
				((IncrementoDecrementoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
					((IncrementoDecrementoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new AsigAddSubContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(ID);
				setState(263);
				((AsigAddSubContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
					((AsigAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(264);
				expr(14);
				}
				break;
			case 5:
				{
				_localctx = new SliceDeclStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				sliceDcl();
				}
				break;
			case 6:
				{
				_localctx = new AccesoSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(ID);
				setState(267);
				match(T__14);
				setState(268);
				expr(0);
				setState(269);
				match(T__15);
				}
				break;
			case 7:
				{
				_localctx = new ExpIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(INT);
				}
				break;
			case 8:
				{
				_localctx = new ExpDoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(DECIMAL);
				}
				break;
			case 9:
				{
				_localctx = new ExpStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(CADENA);
				}
				break;
			case 10:
				{
				_localctx = new ExpBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(BOOLEANO);
				}
				break;
			case 11:
				{
				_localctx = new ExpCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(CARACTER);
				}
				break;
			case 12:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				varCall();
				}
				break;
			case 14:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(PARENTESIS_ABRE);
				setState(279);
				expr(0);
				setState(280);
				match(PARENTESIS_CIERRA);
				}
				break;
			case 15:
				{
				_localctx = new CorchetesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(T__14);
				setState(283);
				expr(0);
				setState(284);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(306);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(289);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199355404288L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(290);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(292);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__26) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(293);
						expr(18);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(295);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(296);
						expr(17);
						}
						break;
					case 4:
						{
						_localctx = new IgualDesigualContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(298);
						((IgualDesigualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((IgualDesigualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(299);
						expr(16);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(300);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(301);
						((AndContext)_localctx).op = match(T__35);
						setState(302);
						expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(304);
						((OrContext)_localctx).op = match(T__36);
						setState(305);
						expr(13);
						}
						break;
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17317308137472L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u013a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001)\b\u0001\n\u0001\f\u0001,\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00010\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00018\b\u0001\u0003\u0001"+
		":\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001B\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001H\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001]\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001a\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001f\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001j\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001o\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u007f\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0083\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u0089\b\u0001\n\u0001\f\u0001\u008c\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0091\b\u0001\u0003\u0001\u0093\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u009e\b\u0002\n\u0002\f\u0002\u00a1"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00a5\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00ab\b\u0003\u0001\u0004"+
		"\u0004\u0004\u00ae\b\u0004\u000b\u0004\f\u0004\u00af\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b6\b\u0005\n\u0005\f\u0005"+
		"\u00b9\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00be\b"+
		"\u0005\n\u0005\f\u0005\u00c1\t\u0005\u0003\u0005\u00c3\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00c7\b\u0006\n\u0006\f\u0006\u00ca\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00d3\b\u0007\u0001\u0007\u0003\u0007\u00d6\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00dc\b\u0007"+
		"\u0003\u0007\u00de\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00e4"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u00e9\b\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00f0\b\n\n\n\f\n\u00f3\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00fb\b\f\n\f\f\f\u00fe"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u011f\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0133\b\r\n"+
		"\r\f\r\u0136\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0001\u001a"+
		"\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u0000\u0007\u0001\u0000\u0017\u0018\u0001\u0000\"#\u0002"+
		"\u0000\u0019\u001a55\u0002\u0000\u0016\u0016\u001b\u001b\u0001\u0000\u001c"+
		"\u001f\u0001\u0000 !\u0001\u0000&+\u016f\u0000!\u0001\u0000\u0000\u0000"+
		"\u0002\u0092\u0001\u0000\u0000\u0000\u0004\u0094\u0001\u0000\u0000\u0000"+
		"\u0006\u00aa\u0001\u0000\u0000\u0000\b\u00ad\u0001\u0000\u0000\u0000\n"+
		"\u00c2\u0001\u0000\u0000\u0000\f\u00c4\u0001\u0000\u0000\u0000\u000e\u00dd"+
		"\u0001\u0000\u0000\u0000\u0010\u00df\u0001\u0000\u0000\u0000\u0012\u00e5"+
		"\u0001\u0000\u0000\u0000\u0014\u00ec\u0001\u0000\u0000\u0000\u0016\u00f4"+
		"\u0001\u0000\u0000\u0000\u0018\u00f7\u0001\u0000\u0000\u0000\u001a\u011e"+
		"\u0001\u0000\u0000\u0000\u001c\u0137\u0001\u0000\u0000\u0000\u001e \u0003"+
		"\u0002\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0001"+
		"\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0001\u0000"+
		"\u0000%*\u0003\u001a\r\u0000&\'\u0005\u0002\u0000\u0000\')\u0003\u001a"+
		"\r\u0000(&\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001"+
		"\u0000\u0000\u0000-/\u00059\u0000\u0000.0\u0005\u0003\u0000\u0000/.\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0093\u0001\u0000\u0000"+
		"\u000012\u0005\u0004\u0000\u000023\u0003\u001a\r\u000039\u0003\f\u0006"+
		"\u000047\u0005\u0005\u0000\u000058\u0003\u0002\u0001\u000068\u0003\f\u0006"+
		"\u000075\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u00008:\u0001\u0000"+
		"\u0000\u000094\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:\u0093"+
		"\u0001\u0000\u0000\u0000;=\u0005\u0006\u0000\u0000<>\u00058\u0000\u0000"+
		"=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?A\u0003\u001a\r\u0000@B\u00059\u0000\u0000A@\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0003\f\u0006"+
		"\u0000D\u0093\u0001\u0000\u0000\u0000EG\u0005\u0006\u0000\u0000FH\u0005"+
		"8\u0000\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000IJ\u0003\u0006\u0003\u0000JK\u0003\u001a\r\u0000KL\u0005"+
		"\u0003\u0000\u0000LN\u0003\u001a\r\u0000MO\u00059\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PQ\u0003\f\u0006\u0000Q\u0093\u0001\u0000\u0000\u0000RS\u0005\u0007\u0000"+
		"\u0000ST\u0003\u001a\r\u0000TU\u0005\b\u0000\u0000UV\u0003\b\u0004\u0000"+
		"VW\u0005\t\u0000\u0000W\u0093\u0001\u0000\u0000\u0000XY\u0005\n\u0000"+
		"\u0000YZ\u00054\u0000\u0000Z\\\u00058\u0000\u0000[]\u0003\u0014\n\u0000"+
		"\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^`\u00059\u0000\u0000_a\u0003\u001c\u000e\u0000`_\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0093\u0003"+
		"\f\u0006\u0000ce\u0005\u000b\u0000\u0000df\u0005\u0003\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0093\u0001\u0000\u0000"+
		"\u0000gi\u0005\f\u0000\u0000hj\u0005\u0003\u0000\u0000ih\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000j\u0093\u0001\u0000\u0000\u0000kl\u0005"+
		"\r\u0000\u0000ln\u0003\u001a\r\u0000mo\u0005\u0003\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0093\u0001\u0000\u0000"+
		"\u0000pq\u0005\u000e\u0000\u0000qr\u00058\u0000\u0000rs\u0003\u001a\r"+
		"\u0000st\u0005\u0002\u0000\u0000tu\u0003\u001a\r\u0000uv\u00059\u0000"+
		"\u0000v\u0093\u0001\u0000\u0000\u0000wx\u00054\u0000\u0000xy\u0005\u000f"+
		"\u0000\u0000yz\u0003\u001a\r\u0000z{\u0005\u0010\u0000\u0000{|\u00056"+
		"\u0000\u0000|~\u0003\u001a\r\u0000}\u007f\u0005\u0003\u0000\u0000~}\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0093\u0001\u0000"+
		"\u0000\u0000\u0080\u0082\u0003\u0012\t\u0000\u0081\u0083\u0005\u0003\u0000"+
		"\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0093\u0001\u0000\u0000\u0000\u0084\u0093\u0003\u0010\b\u0000"+
		"\u0085\u0093\u0003\u000e\u0007\u0000\u0086\u008a\u0005\b\u0000\u0000\u0087"+
		"\u0089\u0003\u0002\u0001\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008d\u0093\u0005\t\u0000\u0000\u008e\u0090"+
		"\u0003\u001a\r\u0000\u008f\u0091\u0005\u0003\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u0001"+
		"\u0000\u0000\u0000\u0092$\u0001\u0000\u0000\u0000\u00921\u0001\u0000\u0000"+
		"\u0000\u0092;\u0001\u0000\u0000\u0000\u0092E\u0001\u0000\u0000\u0000\u0092"+
		"R\u0001\u0000\u0000\u0000\u0092X\u0001\u0000\u0000\u0000\u0092c\u0001"+
		"\u0000\u0000\u0000\u0092g\u0001\u0000\u0000\u0000\u0092k\u0001\u0000\u0000"+
		"\u0000\u0092p\u0001\u0000\u0000\u0000\u0092w\u0001\u0000\u0000\u0000\u0092"+
		"\u0080\u0001\u0000\u0000\u0000\u0092\u0084\u0001\u0000\u0000\u0000\u0092"+
		"\u0085\u0001\u0000\u0000\u0000\u0092\u0086\u0001\u0000\u0000\u0000\u0092"+
		"\u008e\u0001\u0000\u0000\u0000\u0093\u0003\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u00054\u0000\u0000\u0095\u0096\u00057\u0000\u0000\u0096\u0097\u0005"+
		"\u000f\u0000\u0000\u0097\u0098\u0005\u0010\u0000\u0000\u0098\u0099\u0003"+
		"\u001c\u000e\u0000\u0099\u009a\u0005\b\u0000\u0000\u009a\u009f\u0003\u001a"+
		"\r\u0000\u009b\u009c\u0005\u0002\u0000\u0000\u009c\u009e\u0003\u001a\r"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0005\t\u0000\u0000\u00a3\u00a5\u0005\u0003\u0000\u0000"+
		"\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u0005\u0001\u0000\u0000\u0000\u00a6\u00ab\u0003\u000e\u0007\u0000"+
		"\u00a7\u00a8\u0003\u001a\r\u0000\u00a8\u00a9\u0005\u0003\u0000\u0000\u00a9"+
		"\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a7\u0001\u0000\u0000\u0000\u00ab\u0007\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ae\u0003\n\u0005\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b0\t\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0011\u0000\u0000\u00b2\u00b3\u0003\u001a\r\u0000\u00b3\u00b7\u0005\u0012"+
		"\u0000\u0000\u00b4\u00b6\u0003\u0002\u0001\u0000\u00b5\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00c3\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0013"+
		"\u0000\u0000\u00bb\u00bf\u0005\u0012\u0000\u0000\u00bc\u00be\u0003\u0002"+
		"\u0001\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c2\u00b1\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000"+
		"\u0000\u0000\u00c3\u000b\u0001\u0000\u0000\u0000\u00c4\u00c8\u0005\b\u0000"+
		"\u0000\u00c5\u00c7\u0003\u0002\u0001\u0000\u00c6\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\t\u0000\u0000"+
		"\u00cc\r\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0014\u0000\u0000\u00ce"+
		"\u00cf\u00054\u0000\u0000\u00cf\u00d2\u0003\u001c\u000e\u0000\u00d0\u00d1"+
		"\u00056\u0000\u0000\u00d1\u00d3\u0003\u001a\r\u0000\u00d2\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d6\u0005\u0003\u0000\u0000\u00d5\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00de\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u00054\u0000\u0000\u00d8\u00d9\u00057\u0000"+
		"\u0000\u00d9\u00db\u0003\u001a\r\u0000\u00da\u00dc\u0005\u0003\u0000\u0000"+
		"\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000"+
		"\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00cd\u0001\u0000\u0000\u0000"+
		"\u00dd\u00d7\u0001\u0000\u0000\u0000\u00de\u000f\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u00054\u0000\u0000\u00e0\u00e1\u00056\u0000\u0000\u00e1\u00e3"+
		"\u0003\u001a\r\u0000\u00e2\u00e4\u0005\u0003\u0000\u0000\u00e3\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u0011\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u00054\u0000\u0000\u00e6\u00e8\u00058\u0000"+
		"\u0000\u00e7\u00e9\u0003\u0018\f\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u00059\u0000\u0000\u00eb\u0013\u0001\u0000\u0000\u0000\u00ec"+
		"\u00f1\u0003\u0016\u000b\u0000\u00ed\u00ee\u0005\u0002\u0000\u0000\u00ee"+
		"\u00f0\u0003\u0016\u000b\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f2\u0015\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u00054\u0000\u0000\u00f5\u00f6"+
		"\u0003\u001c\u000e\u0000\u00f6\u0017\u0001\u0000\u0000\u0000\u00f7\u00fc"+
		"\u0003\u001a\r\u0000\u00f8\u00f9\u0005\u0002\u0000\u0000\u00f9\u00fb\u0003"+
		"\u001a\r\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u0019\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0006\r\uffff\uffff\u0000\u0100\u0101\u0005\u0015"+
		"\u0000\u0000\u0101\u011f\u0003\u001a\r\u0015\u0102\u0103\u0005\u0016\u0000"+
		"\u0000\u0103\u011f\u0003\u001a\r\u0014\u0104\u0105\u00054\u0000\u0000"+
		"\u0105\u011f\u0007\u0000\u0000\u0000\u0106\u0107\u00054\u0000\u0000\u0107"+
		"\u0108\u0007\u0001\u0000\u0000\u0108\u011f\u0003\u001a\r\u000e\u0109\u011f"+
		"\u0003\u0004\u0002\u0000\u010a\u010b\u00054\u0000\u0000\u010b\u010c\u0005"+
		"\u000f\u0000\u0000\u010c\u010d\u0003\u001a\r\u0000\u010d\u010e\u0005\u0010"+
		"\u0000\u0000\u010e\u011f\u0001\u0000\u0000\u0000\u010f\u011f\u0005/\u0000"+
		"\u0000\u0110\u011f\u00050\u0000\u0000\u0111\u011f\u00053\u0000\u0000\u0112"+
		"\u011f\u00051\u0000\u0000\u0113\u011f\u00052\u0000\u0000\u0114\u011f\u0005"+
		"4\u0000\u0000\u0115\u011f\u0003\u0012\t\u0000\u0116\u0117\u00058\u0000"+
		"\u0000\u0117\u0118\u0003\u001a\r\u0000\u0118\u0119\u00059\u0000\u0000"+
		"\u0119\u011f\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u000f\u0000\u0000"+
		"\u011b\u011c\u0003\u001a\r\u0000\u011c\u011d\u0005\u0010\u0000\u0000\u011d"+
		"\u011f\u0001\u0000\u0000\u0000\u011e\u00ff\u0001\u0000\u0000\u0000\u011e"+
		"\u0102\u0001\u0000\u0000\u0000\u011e\u0104\u0001\u0000\u0000\u0000\u011e"+
		"\u0106\u0001\u0000\u0000\u0000\u011e\u0109\u0001\u0000\u0000\u0000\u011e"+
		"\u010a\u0001\u0000\u0000\u0000\u011e\u010f\u0001\u0000\u0000\u0000\u011e"+
		"\u0110\u0001\u0000\u0000\u0000\u011e\u0111\u0001\u0000\u0000\u0000\u011e"+
		"\u0112\u0001\u0000\u0000\u0000\u011e\u0113\u0001\u0000\u0000\u0000\u011e"+
		"\u0114\u0001\u0000\u0000\u0000\u011e\u0115\u0001\u0000\u0000\u0000\u011e"+
		"\u0116\u0001\u0000\u0000\u0000\u011e\u011a\u0001\u0000\u0000\u0000\u011f"+
		"\u0134\u0001\u0000\u0000\u0000\u0120\u0121\n\u0012\u0000\u0000\u0121\u0122"+
		"\u0007\u0002\u0000\u0000\u0122\u0133\u0003\u001a\r\u0013\u0123\u0124\n"+
		"\u0011\u0000\u0000\u0124\u0125\u0007\u0003\u0000\u0000\u0125\u0133\u0003"+
		"\u001a\r\u0012\u0126\u0127\n\u0010\u0000\u0000\u0127\u0128\u0007\u0004"+
		"\u0000\u0000\u0128\u0133\u0003\u001a\r\u0011\u0129\u012a\n\u000f\u0000"+
		"\u0000\u012a\u012b\u0007\u0005\u0000\u0000\u012b\u0133\u0003\u001a\r\u0010"+
		"\u012c\u012d\n\r\u0000\u0000\u012d\u012e\u0005$\u0000\u0000\u012e\u0133"+
		"\u0003\u001a\r\u000e\u012f\u0130\n\f\u0000\u0000\u0130\u0131\u0005%\u0000"+
		"\u0000\u0131\u0133\u0003\u001a\r\r\u0132\u0120\u0001\u0000\u0000\u0000"+
		"\u0132\u0123\u0001\u0000\u0000\u0000\u0132\u0126\u0001\u0000\u0000\u0000"+
		"\u0132\u0129\u0001\u0000\u0000\u0000\u0132\u012c\u0001\u0000\u0000\u0000"+
		"\u0132\u012f\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000"+
		"\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000"+
		"\u0135\u001b\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0007\u0006\u0000\u0000\u0138\u001d\u0001\u0000\u0000\u0000"+
		"&!*/79=AGN\\`ein~\u0082\u008a\u0090\u0092\u009f\u00a4\u00aa\u00af\u00b7"+
		"\u00bf\u00c2\u00c8\u00d2\u00d5\u00db\u00dd\u00e3\u00e8\u00f1\u00fc\u011e"+
		"\u0132\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}