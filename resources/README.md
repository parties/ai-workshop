# Resources

Every file in this folder is **the content itself** — no instructions mixed in. Upload or use
as-is.

| File | What it is | What to do with it |
|---|---|---|
| [`framework.md`](framework.md) | The four-part prompt framework — Verb, Format, Voice, Context. Full version with examples and rollout plan. | **Upload it** to your Project / Gem / Custom GPT. It's also worth reading yourself. |
| [`sample-assignment.md`](sample-assignment.md) | A deliberately AI-vulnerable CTE assignment. | **Attach it** if you didn't bring one of your own. |

Prompts live in [`../prompts/`](../prompts/).

---

## About `framework.md`

It's written to do two jobs at once, which is fine because they're the same job: teach the
model what you're trying to accomplish, and teach you the same thing.

The line that matters most is near the top — **this framework does not exist to get better
output from an AI, it exists to make student thinking visible.** Without that stated up front,
models optimize for a polished assignment and hand you back the same thinking gap in nicer
clothes.

## About `sample-assignment.md`

Workplace safety, on purpose. It shows up in culinary, welding, ag, health sciences,
construction, and automotive, so most CTE teachers can see their own version of it.

The context that goes with it is already filled in inside
[`../prompts/conversion-prompt-prefilled.md`](../prompts/conversion-prompt-prefilled.md) — you
don't have to assemble anything.

### Why it's a good test case

- A student needs to know **nothing about your shop** to produce a passing paper. The topic is generic enough that the model already has all of it.
- The objective the teacher actually cares about — **prioritizing hazards under pressure** — appears nowhere in the task or the rubric. The rubric rewards listing.
- *"Explain why safety is important"* has one socially correct answer, so thirty students converge on it. Homogenization in miniature.
- Five of the fifty points are spelling and length, which AI does perfectly.

The line in the prefilled context that makes the conversion work is the last one:

> *"I could not tell from any of them whether a student could spot a hazard standing in our room."*

That names the **assessment failure** rather than complaining about cheating. When you write
your own context, aim for that.

---

## If you're running this with a group

Facilitation notes for the group walkthrough:

- Ask for a **verb** first, and take a weak one on purpose — someone will say "list" or "describe." Run it and let the output show why it wasn't enough.
- The **format** suggestion that usually cracks it open: a ranked table with a justification column. Ranking forces judgment in a way listing never does.
- **Voice** options that change the answer completely: a new hire on day one, an insurance adjuster after an incident, a shop supervisor with a deadline.
- The **context** a room will always forget: that the objective is *prioritizing*, not recall. Point at it when they skip it.
