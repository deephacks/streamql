// Generated from StreamQl.g4 by ANTLR 4.2.2

    package deephacks.streamql;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StreamQlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StreamQlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StreamQlParser#ordered}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdered(@NotNull StreamQlParser.OrderedContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull StreamQlParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull StreamQlParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#ordering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdering(@NotNull StreamQlParser.OrderingContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(@NotNull StreamQlParser.SkipContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull StreamQlParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull StreamQlParser.OperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(@NotNull StreamQlParser.FilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull StreamQlParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull StreamQlParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(@NotNull StreamQlParser.LimitContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull StreamQlParser.ValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link StreamQlParser#reversed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReversed(@NotNull StreamQlParser.ReversedContext ctx);
}