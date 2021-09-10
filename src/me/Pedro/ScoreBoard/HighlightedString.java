package me.Pedro.ScoreBoard;

public class HighlightedString extends FrameAnimatedString {
	protected String context;
	protected String normalFormat;
	protected String highlightFormat;
	protected String prefix;
	protected String suffix;

	public HighlightedString(final String context, final String normalFormat, final String highlightFormat) {
		this.prefix = "";
		this.suffix = "";
		this.context = context;
		this.normalFormat = normalFormat;
		this.highlightFormat = highlightFormat;
		this.generateFrames();
	}

	public HighlightedString(final String context, final String normalFormat, final String highlightFormat,
			final String prefix, final String suffix) {
		this.prefix = "";
		this.suffix = "";
		this.context = context;
		this.normalFormat = normalFormat;
		this.highlightFormat = highlightFormat;
		this.prefix = prefix;
		this.suffix = suffix;
		this.generateFrames();
	}

	protected void generateFrames() {
		for (int index = 0; index < this.context.length(); ++index) {
			if (this.context.charAt(index) != ' ') {
				final String highlighted = String.valueOf(String.valueOf(this.normalFormat))
						+ this.context.substring(0, index) + this.highlightFormat + this.context.charAt(index)
						+ this.normalFormat + this.context.substring(index + 1, this.context.length());
				final String whole = String.valueOf(String.valueOf(this.prefix)) + highlighted + this.suffix;
				this.addFrame(whole);
			} else {
				this.addFrame(
						String.valueOf(String.valueOf(this.prefix)) + this.normalFormat + this.context + this.suffix);
			}
		}
	}

	public String getContext() {
		return this.context;
	}

	public String getNormalColor() {
		return this.normalFormat;
	}

	public String getHighlightColor() {
		return this.highlightFormat;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public String getSuffix() {
		return this.suffix;
	}
}
