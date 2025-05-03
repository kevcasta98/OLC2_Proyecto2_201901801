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
		T__38=39, T__39=40, NEWLINE=41, COMENTARIO_LINEA=42, COMENTARIO_MULTILINEA=43, 
		INT=44, DECIMAL=45, BOOLEANO=46, CARACTER=47, CADENA=48, ID=49, MODULO=50, 
		IGUAL=51, DOSPUNTOS_IGUAL=52, PARENTESIS_ABRE=53, PARENTESIS_CIERRA=54;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_forID = 2, RULE_caseList = 3, RULE_caseStmt = 4, 
		RULE_block = 5, RULE_varDcl = 6, RULE_varAsign = 7, RULE_varCall = 8, 
		RULE_parametros = 9, RULE_param = 10, RULE_args = 11, RULE_expr = 12, 
		RULE_tipo = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "forID", "caseList", "caseStmt", "block", "varDcl", 
			"varAsign", "varCall", "parametros", "param", "args", "expr", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fmt.Println('", "','", "';'", "'if'", "'else'", "'for'", "'switch'", 
			"'{'", "'}'", "'func'", "'return'", "'case'", "':'", "'default'", "'var'", 
			"'!'", "'-'", "'++'", "'--'", "'*'", "'/'", "'+'", "'<'", "'<='", "'>'", 
			"'>='", "'=='", "'!='", "'+='", "'-='", "'&&'", "'||'", "'['", "']'", 
			"'int'", "'float64'", "'string'", "'bool'", "'rune'", "'void'", null, 
			null, null, null, null, null, null, null, null, "'%'", "'='", "':='", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "NEWLINE", "COMENTARIO_LINEA", "COMENTARIO_MULTILINEA", 
			"INT", "DECIMAL", "BOOLEANO", "CARACTER", "CADENA", "ID", "MODULO", "IGUAL", 
			"DOSPUNTOS_IGUAL", "PARENTESIS_ABRE", "PARENTESIS_CIERRA"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565706706L) != 0)) {
				{
				{
				setState(28);
				dcl();
				}
				}
				setState(33);
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
	public static class FuncCallStmtContext extends DclContext {
		public VarCallContext varCall() {
			return getRuleContext(VarCallContext.class,0);
		}
		public FuncCallStmtContext(DclContext ctx) { copyFrom(ctx); }
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
	public static class VarDeclStmtContext extends DclContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public VarDeclStmtContext(DclContext ctx) { copyFrom(ctx); }
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
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorParser.PARENTESIS_CIERRA, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorParser.PARENTESIS_ABRE, 0); }
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(T__0);
				setState(35);
				expr(0);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(36);
					match(T__1);
					setState(37);
					expr(0);
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(43);
				match(PARENTESIS_CIERRA);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(44);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(T__3);
				setState(48);
				expr(0);
				setState(49);
				block();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(50);
					match(T__4);
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(51);
						dcl();
						}
						break;
					case 2:
						{
						setState(52);
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
				setState(57);
				match(T__5);
				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(58);
					match(PARENTESIS_ABRE);
					}
					break;
				}
				setState(61);
				expr(0);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARENTESIS_CIERRA) {
					{
					setState(62);
					match(PARENTESIS_CIERRA);
					}
				}

				setState(65);
				block();
				}
				break;
			case 4:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(T__5);
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(68);
					match(PARENTESIS_ABRE);
					}
					break;
				}
				setState(71);
				forID();
				setState(72);
				expr(0);
				setState(73);
				match(T__2);
				setState(74);
				expr(0);
				setState(75);
				match(PARENTESIS_CIERRA);
				setState(76);
				block();
				}
				break;
			case 5:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(T__6);
				setState(79);
				expr(0);
				setState(80);
				match(T__7);
				setState(81);
				caseList();
				setState(82);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new FuncDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				match(T__9);
				setState(85);
				match(ID);
				setState(86);
				match(PARENTESIS_ABRE);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(87);
					parametros();
					}
				}

				setState(90);
				match(PARENTESIS_CIERRA);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) {
					{
					setState(91);
					tipo();
					}
				}

				setState(94);
				block();
				}
				break;
			case 7:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				match(T__10);
				setState(96);
				expr(0);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(97);
					match(T__2);
					}
				}

				}
				break;
			case 8:
				_localctx = new FuncCallStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				varCall();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(101);
					match(T__2);
					}
				}

				}
				break;
			case 9:
				_localctx = new AsignStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				varAsign();
				}
				break;
			case 10:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(105);
				varDcl();
				}
				break;
			case 11:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(106);
				match(T__7);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565706706L) != 0)) {
					{
					{
					setState(107);
					dcl();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113);
				match(T__8);
				}
				break;
			case 12:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(114);
				expr(0);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(115);
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
		enterRule(_localctx, 4, RULE_forID);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				expr(0);
				setState(122);
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
		enterRule(_localctx, 6, RULE_caseList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				caseStmt();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 || _la==T__13 );
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
		enterRule(_localctx, 8, RULE_caseStmt);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(T__11);
				setState(132);
				expr(0);
				setState(133);
				match(T__12);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565706706L) != 0)) {
					{
					{
					setState(134);
					dcl();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(T__13);
				setState(141);
				match(T__12);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565706706L) != 0)) {
					{
					{
					setState(142);
					dcl();
					}
					}
					setState(147);
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
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__7);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565706706L) != 0)) {
				{
				{
				setState(151);
				dcl();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
		enterRule(_localctx, 12, RULE_varDcl);
		int _la;
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__14);
				setState(160);
				match(ID);
				setState(161);
				tipo();
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(162);
					match(IGUAL);
					setState(163);
					expr(0);
					}
				}

				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(166);
					match(T__2);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(ID);
				setState(170);
				match(DOSPUNTOS_IGUAL);
				setState(171);
				expr(0);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(172);
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
		enterRule(_localctx, 14, RULE_varAsign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ID);
			setState(178);
			match(IGUAL);
			setState(179);
			expr(0);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(180);
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
		enterRule(_localctx, 16, RULE_varCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ID);
			setState(184);
			match(PARENTESIS_ABRE);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10115515565670400L) != 0)) {
				{
				setState(185);
				args();
				}
			}

			setState(188);
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
		enterRule(_localctx, 18, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			param();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(191);
				match(T__1);
				setState(192);
				param();
				}
				}
				setState(197);
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
		enterRule(_localctx, 20, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(ID);
			setState(199);
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
		enterRule(_localctx, 22, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			expr(0);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(202);
				match(T__1);
				setState(203);
				expr(0);
				}
				}
				setState(208);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(210);
				match(T__15);
				setState(211);
				expr(19);
				}
				break;
			case 2:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(T__16);
				setState(213);
				expr(18);
				}
				break;
			case 3:
				{
				_localctx = new IncrementoDecrementoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(ID);
				setState(215);
				((IncrementoDecrementoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
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
				setState(216);
				match(ID);
				setState(217);
				((AsigAddSubContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__28 || _la==T__29) ) {
					((AsigAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				expr(12);
				}
				break;
			case 5:
				{
				_localctx = new ExpIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(INT);
				}
				break;
			case 6:
				{
				_localctx = new ExpDoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(DECIMAL);
				}
				break;
			case 7:
				{
				_localctx = new ExpStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(CADENA);
				}
				break;
			case 8:
				{
				_localctx = new ExpBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(BOOLEANO);
				}
				break;
			case 9:
				{
				_localctx = new ExpCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(CARACTER);
				}
				break;
			case 10:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				varCall();
				}
				break;
			case 12:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(PARENTESIS_ABRE);
				setState(227);
				expr(0);
				setState(228);
				match(PARENTESIS_CIERRA);
				}
				break;
			case 13:
				{
				_localctx = new CorchetesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(T__32);
				setState(231);
				expr(0);
				setState(232);
				match(T__33);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(237);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909988352L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(240);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__21) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(243);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new IgualDesigualContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(246);
						((IgualDesigualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((IgualDesigualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(249);
						((AndContext)_localctx).op = match(T__30);
						setState(250);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(252);
						((OrContext)_localctx).op = match(T__31);
						setState(253);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 26, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) ) {
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
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u0106\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000"+
		"\f\u0000!\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001.\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u00016\b\u0001\u0003\u00018\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001<\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"F\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001Y\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001]\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001c\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001g\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001m\b\u0001\n\u0001\f\u0001p\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001u\b\u0001\u0003\u0001w\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002}\b\u0002"+
		"\u0001\u0003\u0004\u0003\u0080\b\u0003\u000b\u0003\f\u0003\u0081\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0088\b\u0004\n"+
		"\u0004\f\u0004\u008b\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u0090\b\u0004\n\u0004\f\u0004\u0093\t\u0004\u0003\u0004\u0095\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u0099\b\u0005\n\u0005\f\u0005"+
		"\u009c\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00a5\b\u0006\u0001\u0006\u0003\u0006"+
		"\u00a8\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00ae\b\u0006\u0003\u0006\u00b0\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00b6\b\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00bb\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t\u00c2\b\t"+
		"\n\t\f\t\u00c5\t\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00cd\b\u000b\n\u000b\f\u000b\u00d0\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00eb\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u00ff\b\f\n\f\f\f\u0102\t\f\u0001\r\u0001\r\u0001\r\u0000\u0001\u0018"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0007\u0001\u0000\u0012\u0013\u0001\u0000\u001d\u001e\u0002"+
		"\u0000\u0014\u001522\u0002\u0000\u0011\u0011\u0016\u0016\u0001\u0000\u0017"+
		"\u001a\u0001\u0000\u001b\u001c\u0001\u0000#(\u0130\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0002v\u0001\u0000\u0000\u0000\u0004|\u0001\u0000\u0000\u0000"+
		"\u0006\u007f\u0001\u0000\u0000\u0000\b\u0094\u0001\u0000\u0000\u0000\n"+
		"\u0096\u0001\u0000\u0000\u0000\f\u00af\u0001\u0000\u0000\u0000\u000e\u00b1"+
		"\u0001\u0000\u0000\u0000\u0010\u00b7\u0001\u0000\u0000\u0000\u0012\u00be"+
		"\u0001\u0000\u0000\u0000\u0014\u00c6\u0001\u0000\u0000\u0000\u0016\u00c9"+
		"\u0001\u0000\u0000\u0000\u0018\u00ea\u0001\u0000\u0000\u0000\u001a\u0103"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0001\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0001\u0000\u0000#(\u0003"+
		"\u0018\f\u0000$%\u0005\u0002\u0000\u0000%\'\u0003\u0018\f\u0000&$\u0001"+
		"\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+-\u00056\u0000\u0000,.\u0005\u0003\u0000\u0000-,\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.w\u0001\u0000\u0000\u0000/0\u0005\u0004"+
		"\u0000\u000001\u0003\u0018\f\u000017\u0003\n\u0005\u000025\u0005\u0005"+
		"\u0000\u000036\u0003\u0002\u0001\u000046\u0003\n\u0005\u000053\u0001\u0000"+
		"\u0000\u000054\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000072\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008w\u0001\u0000\u0000\u0000"+
		"9;\u0005\u0006\u0000\u0000:<\u00055\u0000\u0000;:\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0003\u0018\f\u0000"+
		">@\u00056\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AB\u0003\n\u0005\u0000Bw\u0001\u0000\u0000\u0000"+
		"CE\u0005\u0006\u0000\u0000DF\u00055\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0003\u0004\u0002"+
		"\u0000HI\u0003\u0018\f\u0000IJ\u0005\u0003\u0000\u0000JK\u0003\u0018\f"+
		"\u0000KL\u00056\u0000\u0000LM\u0003\n\u0005\u0000Mw\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0007\u0000\u0000OP\u0003\u0018\f\u0000PQ\u0005\b\u0000"+
		"\u0000QR\u0003\u0006\u0003\u0000RS\u0005\t\u0000\u0000Sw\u0001\u0000\u0000"+
		"\u0000TU\u0005\n\u0000\u0000UV\u00051\u0000\u0000VX\u00055\u0000\u0000"+
		"WY\u0003\u0012\t\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z\\\u00056\u0000\u0000[]\u0003\u001a\r\u0000"+
		"\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^w\u0003\n\u0005\u0000_`\u0005\u000b\u0000\u0000`b\u0003\u0018\f"+
		"\u0000ac\u0005\u0003\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cw\u0001\u0000\u0000\u0000df\u0003\u0010\b\u0000eg\u0005\u0003"+
		"\u0000\u0000fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gw\u0001"+
		"\u0000\u0000\u0000hw\u0003\u000e\u0007\u0000iw\u0003\f\u0006\u0000jn\u0005"+
		"\b\u0000\u0000km\u0003\u0002\u0001\u0000lk\u0001\u0000\u0000\u0000mp\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qw\u0005\t\u0000\u0000"+
		"rt\u0003\u0018\f\u0000su\u0005\u0003\u0000\u0000ts\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000v\"\u0001\u0000\u0000"+
		"\u0000v/\u0001\u0000\u0000\u0000v9\u0001\u0000\u0000\u0000vC\u0001\u0000"+
		"\u0000\u0000vN\u0001\u0000\u0000\u0000vT\u0001\u0000\u0000\u0000v_\u0001"+
		"\u0000\u0000\u0000vd\u0001\u0000\u0000\u0000vh\u0001\u0000\u0000\u0000"+
		"vi\u0001\u0000\u0000\u0000vj\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000"+
		"\u0000w\u0003\u0001\u0000\u0000\u0000x}\u0003\f\u0006\u0000yz\u0003\u0018"+
		"\f\u0000z{\u0005\u0003\u0000\u0000{}\u0001\u0000\u0000\u0000|x\u0001\u0000"+
		"\u0000\u0000|y\u0001\u0000\u0000\u0000}\u0005\u0001\u0000\u0000\u0000"+
		"~\u0080\u0003\b\u0004\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0007\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005\f\u0000\u0000\u0084\u0085\u0003\u0018\f\u0000\u0085\u0089\u0005"+
		"\r\u0000\u0000\u0086\u0088\u0003\u0002\u0001\u0000\u0087\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0095\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u000e"+
		"\u0000\u0000\u008d\u0091\u0005\r\u0000\u0000\u008e\u0090\u0003\u0002\u0001"+
		"\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0083\u0001\u0000\u0000\u0000\u0094\u008c\u0001\u0000\u0000"+
		"\u0000\u0095\t\u0001\u0000\u0000\u0000\u0096\u009a\u0005\b\u0000\u0000"+
		"\u0097\u0099\u0003\u0002\u0001\u0000\u0098\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005\t\u0000\u0000\u009e"+
		"\u000b\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000f\u0000\u0000\u00a0"+
		"\u00a1\u00051\u0000\u0000\u00a1\u00a4\u0003\u001a\r\u0000\u00a2\u00a3"+
		"\u00053\u0000\u0000\u00a3\u00a5\u0003\u0018\f\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a8\u0005\u0003\u0000\u0000\u00a7\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00b0\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u00051\u0000\u0000\u00aa\u00ab\u00054\u0000"+
		"\u0000\u00ab\u00ad\u0003\u0018\f\u0000\u00ac\u00ae\u0005\u0003\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u009f\u0001\u0000\u0000\u0000"+
		"\u00af\u00a9\u0001\u0000\u0000\u0000\u00b0\r\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u00051\u0000\u0000\u00b2\u00b3\u00053\u0000\u0000\u00b3\u00b5\u0003"+
		"\u0018\f\u0000\u00b4\u00b6\u0005\u0003\u0000\u0000\u00b5\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u000f\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u00051\u0000\u0000\u00b8\u00ba\u00055\u0000\u0000"+
		"\u00b9\u00bb\u0003\u0016\u000b\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u00056\u0000\u0000\u00bd\u0011\u0001\u0000\u0000\u0000\u00be"+
		"\u00c3\u0003\u0014\n\u0000\u00bf\u00c0\u0005\u0002\u0000\u0000\u00c0\u00c2"+
		"\u0003\u0014\n\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u0013\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u00051\u0000\u0000\u00c7\u00c8\u0003\u001a"+
		"\r\u0000\u00c8\u0015\u0001\u0000\u0000\u0000\u00c9\u00ce\u0003\u0018\f"+
		"\u0000\u00ca\u00cb\u0005\u0002\u0000\u0000\u00cb\u00cd\u0003\u0018\f\u0000"+
		"\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000"+
		"\u00cf\u0017\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0006\f\uffff\uffff\u0000\u00d2\u00d3\u0005\u0010\u0000\u0000"+
		"\u00d3\u00eb\u0003\u0018\f\u0013\u00d4\u00d5\u0005\u0011\u0000\u0000\u00d5"+
		"\u00eb\u0003\u0018\f\u0012\u00d6\u00d7\u00051\u0000\u0000\u00d7\u00eb"+
		"\u0007\u0000\u0000\u0000\u00d8\u00d9\u00051\u0000\u0000\u00d9\u00da\u0007"+
		"\u0001\u0000\u0000\u00da\u00eb\u0003\u0018\f\f\u00db\u00eb\u0005,\u0000"+
		"\u0000\u00dc\u00eb\u0005-\u0000\u0000\u00dd\u00eb\u00050\u0000\u0000\u00de"+
		"\u00eb\u0005.\u0000\u0000\u00df\u00eb\u0005/\u0000\u0000\u00e0\u00eb\u0005"+
		"1\u0000\u0000\u00e1\u00eb\u0003\u0010\b\u0000\u00e2\u00e3\u00055\u0000"+
		"\u0000\u00e3\u00e4\u0003\u0018\f\u0000\u00e4\u00e5\u00056\u0000\u0000"+
		"\u00e5\u00eb\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005!\u0000\u0000\u00e7"+
		"\u00e8\u0003\u0018\f\u0000\u00e8\u00e9\u0005\"\u0000\u0000\u00e9\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ea\u00d1\u0001\u0000\u0000\u0000\u00ea\u00d4"+
		"\u0001\u0000\u0000\u0000\u00ea\u00d6\u0001\u0000\u0000\u0000\u00ea\u00d8"+
		"\u0001\u0000\u0000\u0000\u00ea\u00db\u0001\u0000\u0000\u0000\u00ea\u00dc"+
		"\u0001\u0000\u0000\u0000\u00ea\u00dd\u0001\u0000\u0000\u0000\u00ea\u00de"+
		"\u0001\u0000\u0000\u0000\u00ea\u00df\u0001\u0000\u0000\u0000\u00ea\u00e0"+
		"\u0001\u0000\u0000\u0000\u00ea\u00e1\u0001\u0000\u0000\u0000\u00ea\u00e2"+
		"\u0001\u0000\u0000\u0000\u00ea\u00e6\u0001\u0000\u0000\u0000\u00eb\u0100"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\n\u0010\u0000\u0000\u00ed\u00ee\u0007"+
		"\u0002\u0000\u0000\u00ee\u00ff\u0003\u0018\f\u0011\u00ef\u00f0\n\u000f"+
		"\u0000\u0000\u00f0\u00f1\u0007\u0003\u0000\u0000\u00f1\u00ff\u0003\u0018"+
		"\f\u0010\u00f2\u00f3\n\u000e\u0000\u0000\u00f3\u00f4\u0007\u0004\u0000"+
		"\u0000\u00f4\u00ff\u0003\u0018\f\u000f\u00f5\u00f6\n\r\u0000\u0000\u00f6"+
		"\u00f7\u0007\u0005\u0000\u0000\u00f7\u00ff\u0003\u0018\f\u000e\u00f8\u00f9"+
		"\n\u000b\u0000\u0000\u00f9\u00fa\u0005\u001f\u0000\u0000\u00fa\u00ff\u0003"+
		"\u0018\f\f\u00fb\u00fc\n\n\u0000\u0000\u00fc\u00fd\u0005 \u0000\u0000"+
		"\u00fd\u00ff\u0003\u0018\f\u000b\u00fe\u00ec\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ef\u0001\u0000\u0000\u0000\u00fe\u00f2\u0001\u0000\u0000\u0000\u00fe"+
		"\u00f5\u0001\u0000\u0000\u0000\u00fe\u00f8\u0001\u0000\u0000\u0000\u00fe"+
		"\u00fb\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100"+
		"\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101"+
		"\u0019\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0007\u0006\u0000\u0000\u0104\u001b\u0001\u0000\u0000\u0000 \u001f"+
		"(-57;?EX\\bfntv|\u0081\u0089\u0091\u0094\u009a\u00a4\u00a7\u00ad\u00af"+
		"\u00b5\u00ba\u00c3\u00ce\u00ea\u00fe\u0100";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}