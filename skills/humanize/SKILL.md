---
name: humanize
description: "Rewrite or draft standalone prose documents so they read like a person wrote them, not a language model: cut AI tells, ground vague claims in verifiable specifics, keep a real point of view, never fabricate details. Use when authoring or revising a prose artifact for human readers (README, docs, blog post, announcement, email, wiki/Confluence page, proposal, PR description narrative), including requests like 'draft an announcement', 'make this less robotic', 'make this sound less corporate', 'punch this up', or 'this sounds like AI'. Do NOT use for ordinary in-chat answers or explanations, code, code comments, commit messages, review findings, status updates, API reference tables, or any task where the user asked for terse technical output."
---

# Humanize

Make prose read like a specific person wrote it for a specific reader. Apply this while drafting, not as a cosmetic pass after the fact; structure decided early (wall-of-bullets, three-part everything) can't be polished away later.

## Why This Exists

Readers discount text that smells generated, even when its content is right. The tells are mostly structural: every sentence the same length, every list exactly three items, every section opened with a bolded topic sentence and closed by restating itself. The fix is not "sound casual." It is the set of edits a good human editor makes: cut filler, ground claims in specifics, commit to a point of view.

## When To Use

Any prose a human will read as a document: READMEs, docs, blog posts, announcements, emails, wiki pages, proposals, the narrative part of a PR description. Applies to both fresh drafts and rewrites.

Do not apply to: code, code comments, commit messages, API or reference material where uniform structure is the point, legal or compliance text, or short in-chat answers.

## Hard Constraints (read before rewriting)

**Never fabricate specifics.** This is the one way this skill can do real damage. "Make it credible" must never become "make it convincingly fake." Use only specifics that already exist in the source text, the user's messages, or the repo you can actually read. If a claim needs a concrete detail you don't have (a number, an incident, an example, a name), insert a marked placeholder and ask:

> `[NEED: real example of a rollback that took too long]`

A placeholder the user fills in beats a plausible anecdote that never happened, especially in anything published under their name.

Fabricated facts include commitments on behalf of real people: naming someone as a contact point, volunteering their time, or promising their follow-up counts as an invented fact unless the user supplied it. "Dana led the migration" does not license "reach out to Dana with questions."

Two refinements on sourcing and density:

- Repo-derived specifics must come from files you actually read this session, not from inferences off filenames or directory structure. If you inferred the audience or intent rather than being told, label it as inference or confirm it; don't silently assert it.
- Scale placeholder density to the material. When the source has no real facts at all, an honest skeleton of placeholders plus a short list of questions IS the deliverable; say so. When you have partial material, keep the prose readable: write the sentences you can support, and consolidate the gaps into a few placeholders or a trailing question list rather than perforating every line.

**Opinions must be real.** Sharpen conviction the text already carries, or that the user has stated. Do not invent stances. Manufactured confidence ("this is a game-changer") is itself an AI tell and reads as filler.

**Never trade meaning for tone.** Keep every caveat, number, and technical distinction. If a sentence is vague because the underlying thinking is vague, flag it; don't paper over it with livelier vagueness.

**User style rules override this skill.** In this setup that includes: no em dashes, concise by default, plain language with load-bearing terms glossed once.

## The Default Pass (three lenses, one rewrite)

Apply all three together; they are lenses on one edit, not sequential drafts.

### 1. Cut the AI tells

- Vary sentence length deliberately. A three-word sentence after two long ones is how emphasis works in human prose. Uniform 15-to-20-word sentences are the single strongest tell.
- Kill stock transitions (Moreover, Furthermore, Additionally, In conclusion, It's worth noting) and stock frames ("It's not just X, it's Y", "In today's fast-paced world", "Let's dive in").
- Delete filler that hedges without informing: "arguably", "essentially", "at the end of the day", "plays a crucial role".
- Break the rule of three. If everything comes in threes, cut one or add a fourth.
- Stop over-explaining. Say a thing once; trust the reader. Delete summary sentences that restate the paragraph they end.
- Prefer prose over bullets unless the content is genuinely a list. Bolded-topic-sentence-per-bullet is a strong tell.

### 2. Ground every claim

- Replace category words with the actual thing: not "improved performance significantly" but the number; not "various tools" but the tools' names.
- One concrete example beats three abstract assertions. Pull examples from the source material or ask (see the fabrication constraint).
- Cut any sentence that would be equally true of a competitor's product, another team's project, or a different decade. If it's that generic, it's carrying no information.
- Exception: statements that are intentionally general are correct as-is. Compatibility notes, caveats, and scoped qualitative guidance ("works with any S3-compatible store") don't need a number bolted on. Ground claims that are vague because they're empty, not claims that are general because the truth is general.

### 3. Give it a voice

- Write to one sharp reader, not an audience. If the user has named the audience, use it; otherwise infer from the artifact (a README's reader is a developer deciding whether to use the thing).
- Plain words over impressive ones: "use" not "utilize", "start" not "commence".
- Where the text takes a position, state it plainly instead of hedging it into committee language. "We chose X because Y" beats "X was selected as it was deemed to offer certain advantages."
- Small asides and observations are welcome when true and earned; forced folksiness is as bad as corporate stiffness.
- No semicolons, in any output this skill produces. Split the sentence or use a comma instead. The user never writes one, so a semicolon reads as someone else's voice.

## Opt-In: Show the Thinking

Only when the user asks for a reflective register (personal essay, design retrospective, "walk through the tradeoffs"), also surface the reasoning texture: tradeoffs weighed, what was tried and rejected, open questions still live. Genuine second-guessing reads human; performed uncertainty reads worse than none. Skip this mode entirely for runbooks, announcements, and reference docs, where confidence and brevity are the point.

## Procedure

1. Read the whole piece (or gather the facts, for a fresh draft). Name the reader and the purpose in one line before writing.
2. Inventory the specifics you actually have: facts in the source, facts the user gave, facts verifiable from the repo. This inventory is the boundary of what the output may claim.
3. Rewrite with the three lenses above.
4. **Fabrication audit.** List every number, proper noun, anecdote, and claimed observation in your output. Each must trace to the inventory from step 2. Replace anything unsourced with a `[NEED: ...]` placeholder. This check must be able to fail; if you can't point to the source of a detail, it goes.
5. Rhythm check: scan sentence lengths. If three consecutive sentences are within a few words of each other, break one up or merge two.

## Examples

**Tell removal, grounding:**

Before:
> This tool offers significant performance improvements and integrates seamlessly with your existing workflow. It's not just a linter, it's a complete code-quality solution.

After:
> It lints a 40k-line repo in about two seconds, so it runs on every save instead of every commit. `[NEED: confirm the 2s number on your machine]`

**Voice, committee language:**

Before:
> After careful consideration of various alternatives, PostgreSQL was selected as the database solution due to its robust feature set.

After:
> We picked Postgres. We needed transactional guarantees around the queue table, and the team already runs it in production.
