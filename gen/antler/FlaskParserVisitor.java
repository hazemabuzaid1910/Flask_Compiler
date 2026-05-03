// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/FlaskParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskParserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FlaskParserParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FlaskParserParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(FlaskParserParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#importAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAlias(FlaskParserParser.ImportAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(FlaskParserParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(FlaskParserParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(FlaskParserParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(FlaskParserParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(FlaskParserParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#parameterFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterFunction(FlaskParserParser.ParameterFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(FlaskParserParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#decoratorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorStatement(FlaskParserParser.DecoratorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#routerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouterStatement(FlaskParserParser.RouterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(FlaskParserParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(FlaskParserParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(FlaskParserParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(FlaskParserParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(FlaskParserParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FlaskParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FlaskParserParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(FlaskParserParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FlaskParserParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(FlaskParserParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(FlaskParserParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(FlaskParserParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(FlaskParserParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(FlaskParserParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(FlaskParserParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FlaskParserParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(FlaskParserParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(FlaskParserParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(FlaskParserParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParserParser#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(FlaskParserParser.ListComprehensionContext ctx);
}