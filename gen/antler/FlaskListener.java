// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/Flask.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Flask}.
 */
public interface FlaskListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Flask#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AST.Flask.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AST.Flask.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AST.Flask.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AST.Flask.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(AST.Flask.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(AST.Flask.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AST.Flask.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AST.Flask.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(AST.Flask.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(AST.Flask.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#importAlias}.
	 * @param ctx the parse tree
	 */
	void enterImportAlias(AST.Flask.ImportAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#importAlias}.
	 * @param ctx the parse tree
	 */
	void exitImportAlias(AST.Flask.ImportAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(AST.Flask.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(AST.Flask.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(AST.Flask.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(AST.Flask.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(AST.Flask.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(AST.Flask.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(AST.Flask.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(AST.Flask.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void enterParameterFunction(AST.Flask.ParameterFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void exitParameterFunction(AST.Flask.ParameterFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(AST.Flask.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(AST.Flask.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#decoratorStatement}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorStatement(AST.Flask.DecoratorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#decoratorStatement}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorStatement(AST.Flask.DecoratorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#routerStatement}.
	 * @param ctx the parse tree
	 */
	void enterRouterStatement(AST.Flask.RouterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#routerStatement}.
	 * @param ctx the parse tree
	 */
	void exitRouterStatement(AST.Flask.RouterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(AST.Flask.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(AST.Flask.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(AST.Flask.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(AST.Flask.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(AST.Flask.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(AST.Flask.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(AST.Flask.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(AST.Flask.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(AST.Flask.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(AST.Flask.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AST.Flask.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AST.Flask.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(AST.Flask.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(AST.Flask.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(AST.Flask.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(AST.Flask.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(AST.Flask.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(AST.Flask.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(AST.Flask.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(AST.Flask.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(AST.Flask.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(AST.Flask.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(AST.Flask.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(AST.Flask.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(AST.Flask.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(AST.Flask.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(AST.Flask.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(AST.Flask.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(AST.Flask.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(AST.Flask.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AST.Flask.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AST.Flask.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(AST.Flask.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(AST.Flask.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(AST.Flask.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(AST.Flask.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(AST.Flask.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(AST.Flask.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Flask#listComprehension}.
	 * @param ctx the parse tree
	 */
	void enterListComprehension(AST.Flask.ListComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Flask#listComprehension}.
	 * @param ctx the parse tree
	 */
	void exitListComprehension(AST.Flask.ListComprehensionContext ctx);
}