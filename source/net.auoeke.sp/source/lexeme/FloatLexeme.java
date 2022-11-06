package net.auoeke.sp.source.lexeme;

import java.math.BigDecimal;
import net.auoeke.sp.source.NodeTransformer;
import net.auoeke.sp.source.NodeVisitor;

public final class FloatLexeme extends Lexeme {
	public String source;
	public BigDecimal value;

	public FloatLexeme(Position position, String source, BigDecimal value) {
		super(position);

		this.source = source;
		this.value = value;
	}

	@Override public Token token() {
		return Token.STRING;
	}

	@Override public boolean is(Token token) {
		return token == Token.STRING;
	}

	@Override public boolean isPrimitive() {
		return true;
	}

	@Override public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override public <T> T accept(NodeTransformer<T> transformer) {
		return transformer.transform(this);
	}

	@Override public String toString() {
		return this.source;
	}

	@Override public boolean isValue() {
		return true;
	}
}