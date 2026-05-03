// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/FlaskParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskParserParser}.
 */
public interface FlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskParserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FlaskParserParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FlaskParserParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FlaskParserParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FlaskParserParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(FlaskParserParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(FlaskParserParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void enterImportAlias(FlaskParserParser.ImportAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void exitImportAlias(FlaskParserParser.ImportAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(FlaskParserParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(FlaskParserParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(FlaskParserParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(FlaskParserParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(FlaskParserParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(FlaskParserParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(FlaskParserParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(FlaskParserParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(FlaskParserParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(FlaskParserParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void enterParameterFunction(FlaskParserParser.ParameterFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void exitParameterFunction(FlaskParserParser.ParameterFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(FlaskParserParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(FlaskParserParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#decoratorStatement}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorStatement(FlaskParserParser.DecoratorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#decoratorStatement}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorStatement(FlaskParserParser.DecoratorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#routerStatement}.
	 * @param ctx the parse tree
	 */
	void enterRouterStatement(FlaskParserParser.RouterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#routerStatement}.
	 * @param ctx the parse tree
	 */
	void exitRouterStatement(FlaskParserParser.RouterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(FlaskParserParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(FlaskParserParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(FlaskParserParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(FlaskParserParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(FlaskParserParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(FlaskParserParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(FlaskParserParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(FlaskParserParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(FlaskParserParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(FlaskParserParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FlaskParserParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FlaskParserParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(FlaskParserParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(FlaskParserParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(FlaskParserParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(FlaskParserParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FlaskParserParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FlaskParserParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(FlaskParserParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(FlaskParserParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(FlaskParserParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(FlaskParserParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(FlaskParserParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(FlaskParserParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(FlaskParserParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(FlaskParserParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(FlaskParserParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(FlaskParserParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(FlaskParserParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(FlaskParserParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(FlaskParserParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(FlaskParserParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(FlaskParserParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(FlaskParserParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(FlaskParserParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(FlaskParserParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(FlaskParserParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(FlaskParserParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParserParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void enterListComprehension(FlaskParserParser.ListComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParserParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void exitListComprehension(FlaskParserParser.ListComprehensionContext ctx);
}