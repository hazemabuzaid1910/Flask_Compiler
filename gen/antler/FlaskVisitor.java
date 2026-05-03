// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/Flask.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Flask}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Flask#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AST.Flask.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AST.Flask.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(AST.Flask.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(AST.Flask.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(AST.Flask.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#importAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAlias(AST.Flask.ImportAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(AST.Flask.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(AST.Flask.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(AST.Flask.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(AST.Flask.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#parameterFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterFunction(AST.Flask.ParameterFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(AST.Flask.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#decoratorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorStatement(AST.Flask.DecoratorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#routerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouterStatement(AST.Flask.RouterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(AST.Flask.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(AST.Flask.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(AST.Flask.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(AST.Flask.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(AST.Flask.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AST.Flask.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(AST.Flask.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(AST.Flask.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(AST.Flask.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(AST.Flask.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(AST.Flask.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(AST.Flask.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(AST.Flask.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(AST.Flask.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(AST.Flask.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AST.Flask.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(AST.Flask.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(AST.Flask.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(AST.Flask.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Flask#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(AST.Flask.ListComprehensionContext ctx);
}